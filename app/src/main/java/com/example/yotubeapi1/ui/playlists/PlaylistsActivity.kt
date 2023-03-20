package com.example.yotubeapi1.ui.playlists

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.yotubeapi1.core.extension.showToast
import com.example.yotubeapi1.core.network.results.Status
import com.example.yotubeapi1.core.ui.BaseActivity
import com.example.yotubeapi1.data.local.AppPrefs
import com.example.yotubeapi1.databinding.PlaylistsMainBinding

import com.example.yotubeapi1.ui.itemplaylists.ItemPlaylistsActivity
import com.example.yotubeapi1.ui.playlists.adapter.AdapterPlaylists
import com.example.yotubeapi1.ui.playlists.adapter.PlaylistsViewModel
import com.example.yotubeapi1.utils.InternetConnection


class PlaylistActivity : BaseActivity<PlaylistsViewModel, PlaylistsMainBinding>() {

    private lateinit var adapter: AdapterPlaylists
    private lateinit var internetConnection: InternetConnection

    override val viewModel: PlaylistsViewModel by lazy {
        ViewModelProvider(this)[PlaylistsViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): PlaylistsMainBinding {
        return PlaylistsMainBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {
        internetConnection = InternetConnection(application = application)
        internetConnection.observe(this) { isConnected ->
            if (isConnected) {
                binding.includeInternetCheck.root.visibility = View.GONE

            } else {
                binding.includeInternetCheck.root.visibility = View.VISIBLE
            }

        }
    }

    override fun initView() {
        viewModel.loading.observe(this){
            binding.progressCircular.isVisible = it
        }
        viewModel.getPlaylists().observe(this) {
            adapter = AdapterPlaylists{val intent = Intent(this, ItemPlaylistsActivity::class.java)
                intent.putExtra(KEY, it.id)
                startActivity(intent)

            }
            when(it.status){
                Status.SUCCESS ->{
                    it.data?.let { it1 -> adapter.setPlaylists(it1.items) }
                    binding.rvPlaylists.adapter = adapter
                    viewModel.loading.postValue(false)


                }
                Status.LOADING ->{
                    viewModel.loading.postValue(true)
                }
                Status.ERROR->{
                    viewModel.loading.postValue(false)
                    showToast(it.message.toString())
                }
            }

        }
    }

    override fun initListener() {
        Log.d("ololo", AppPrefs(this).onBoard.toString())
        binding.includeInternetCheck.btnTryAgain.setOnClickListener{
            showToast("No connection")

        }
    }

    companion object{
        const val KEY="next"
    }
}