package com.example.yotubeapi1.ui.itemplaylists.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yotubeapi1.core.extension.glide
import com.example.yotubeapi1.data.remote.model.Items
import com.example.yotubeapi1.databinding.ItemplaylistsBinding

class AdapterItemPlaylists(val onClick : (Items) ->Unit): RecyclerView.Adapter<AdapterItemPlaylists.ContentViewHolder>() {

    private val items = arrayListOf<Items>()
    inner class ContentViewHolder(private val binding: ItemplaylistsBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Items) = with(binding){
            imgItemPlaylist.glide(items.snippet.thumbnails.medium.url)
            tvItemPlaylist.text = items.snippet.title
            tvDesc.text = items.snippet.publishedAt
            cardView.visibility = View.GONE
            itemView.setOnClickListener {
                onClick(items)
            }
        }
    }
    fun setItems(list: List<Items>) {
        items.clear()
        items.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        return ContentViewHolder(
            ItemplaylistsBinding.inflate
                (
                LayoutInflater.from(
                    parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(items[position])

    }

}