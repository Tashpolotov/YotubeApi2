package com.example.yotubeapi1.ui.videolists.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yotubeapi1.core.extension.glide
import com.example.yotubeapi1.data.remote.model.Items
import com.example.yotubeapi1.databinding.ActivityVideoPlaylistsBinding
import com.example.yotubeapi1.databinding.ItemVideoBinding

class AdapterVideoLists : RecyclerView.Adapter<AdapterVideoLists.VideoListsViewHolder>(){

    private val items = arrayListOf<Items>()
    inner class VideoListsViewHolder(private val binding: ItemVideoBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Items) = with(binding) {
            imgItemPlaylist.glide(items.snippet.thumbnails.medium.url)


        }



        }
                fun setItems(list: List<Items>) {
            items.clear()
            items.addAll(list)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoListsViewHolder {
        return VideoListsViewHolder(ItemVideoBinding.inflate(LayoutInflater.from
            (parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VideoListsViewHolder, position: Int) {
        holder.bind(items[position])
    }
}