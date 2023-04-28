package com.example.yotubeapi1.ui.videolists.adapter

import androidx.lifecycle.LiveData
import com.example.yotubeapi1.core.network.results.Resource
import com.example.yotubeapi1.core.ui.BaseViewModel
import com.example.yotubeapi1.data.remote.model.Playlists
import com.example.yotubeapi1.repository.Repository

class VideoViewModel (private val repository: Repository): BaseViewModel() {

    fun getVideo(videoId:String): LiveData<Resource<Playlists>> {
        return repository.getVideo(videoId)
    }
}