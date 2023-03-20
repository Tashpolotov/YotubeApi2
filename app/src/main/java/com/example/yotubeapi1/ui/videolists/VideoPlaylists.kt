package com.example.yotubeapi1.ui.videolists
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.yotubeapi1.core.extension.glide
import com.example.yotubeapi1.core.ui.BaseActivity
import com.example.yotubeapi1.databinding.ActivityVideoPlaylistsBinding
import com.example.yotubeapi1.ui.itemplaylists.adapter.ItemViewModel
import com.example.yotubeapi1.ui.playlists.PlaylistActivity
import com.example.yotubeapi1.ui.videolists.adapter.AdapterVideoLists

class VideoPlaylists() : BaseActivity<ItemViewModel, ActivityVideoPlaylistsBinding> () {

    private lateinit var adapter: AdapterVideoLists

    override val viewModel: ItemViewModel by lazy {
        ViewModelProvider(this)[ItemViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityVideoPlaylistsBinding {
        return ActivityVideoPlaylistsBinding.inflate(layoutInflater)
    }

    override fun initView() {
        adapter = AdapterVideoLists()
        val id = intent.getStringExtra(PlaylistActivity.KEY)
        id?.let { _ ->
            viewModel.getItemPlaylists(id).observe(this) {


                it.data?.let { it1 -> adapter.setItems(it1.items) }
            }
        }

    }

    override fun initListener() {
        var player ="https://www.youtube.com/watch?v=wIK2hcc0K-I" + "/0.jpg"

    }
}
