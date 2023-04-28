package com.example.yotubeapi1.ui.itemplaylists

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.core.view.isVisible
import com.example.yotubeapi1.core.ui.BaseActivity
import com.example.yotubeapi1.databinding.ActivityItemPlaylistsBinding
import com.example.yotubeapi1.ui.itemplaylists.adapter.AdapterItemPlaylists
import com.example.yotubeapi1.ui.itemplaylists.adapter.ItemViewModel
import com.example.yotubeapi1.ui.videolists.VideoPlaylists
import com.example.yotubeapi1.utils.InternetConnection

class ItemPlaylistsActivity : BaseActivity<ItemViewModel, ActivityItemPlaylistsBinding>() {
    override val viewModel: ItemViewModel by viewModel()

    private lateinit var adapter: AdapterItemPlaylists
    private lateinit var internetConnection: InternetConnection


    override fun inflateViewBinding(inflater: LayoutInflater): ActivityItemPlaylistsBinding {
        return ActivityItemPlaylistsBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {
        super.checkInternet()
        internetConnection = InternetConnection(application = application)
        internetConnection.observe(this) { isConnected ->
            if (isConnected) {
                binding.noInternet.root.visibility = View.GONE

            } else {
                binding.noInternet.root.visibility = View.VISIBLE
            }

        }
    }


    override fun initView() {

        viewModel.loading.observe(this) {
            binding.progressCircular.isVisible = it
        }
        viewModel.getItemPlaylists(this.toString()).observe(this) {
            adapter = AdapterItemPlaylists {
                val intent = Intent(this, VideoPlaylists::class.java)
                intent.putExtra(KEY, it.id)
                intent.putExtra(KEY_TITLE, it.snippet.title)
                intent.putExtra(KEY_DESC, it.snippet.description)
                startActivity(intent)

            }
            val id = intent.getStringExtra(KEY)
            id?.let { _ ->
                viewModel.getItemPlaylists(id).observe(this) {
                    binding.rvContent.adapter = adapter

                    it.data?.let { it1 -> adapter.setItems(it1.items) }
                }
            }
        }
    }

    override fun initListener() {
        binding.toolbar.tvToolbar.setOnClickListener{
            this.onBackPressed()
        }
    }

    companion object{
        const val KEY="next"
        const val KEY_DESC = "desc"
        const val KEY_TITLE = "title"
    }
}