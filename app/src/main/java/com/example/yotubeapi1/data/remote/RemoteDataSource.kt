package com.example.yotubeapi1.data.remote

import com.example.yotubeapi1.BuildConfig
import com.example.yotubeapi1.core.network.BaseDataSource
import com.example.yotubeapi1.core.network.RetrofitClient


class RemoteDataSource: BaseDataSource() {

    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    suspend fun getPlaylists() = getResult {

        apiService.getPlaylists(
            BuildConfig.API_KEY, "UCWOA1ZGywLbqmigxE4Qlvuw",
            "snippet,contentDetails"
        )
    }


    suspend fun getItemplaylists(id: String)= getResult {
            apiService.getItemLists(
                BuildConfig.API_KEY, "snippet",
                id
            )
        }
    }
