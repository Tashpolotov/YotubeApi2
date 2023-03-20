package com.example.yotubeapi1.ui.playlists.adapter

import androidx.lifecycle.LiveData
import com.example.yotubeapi1.App.Companion.repository
import com.example.yotubeapi1.core.network.results.Resource
import com.example.yotubeapi1.core.ui.BaseViewModel
import com.example.yotubeapi1.data.remote.model.Playlists

class PlaylistsViewModel:  BaseViewModel() {

    fun getPlaylists(): LiveData<Resource<Playlists>> {
        return repository.getPlaylists()

    }
}