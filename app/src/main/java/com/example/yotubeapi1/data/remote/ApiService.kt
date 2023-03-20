package com.example.yotubeapi1.data.remote

import com.example.yotubeapi1.data.remote.model.Playlists
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    suspend fun getPlaylists(
        @Query("key") apiKey: String,
        @Query("channelId") channelId: String,
        @Query("part") part: String

    ): Response<Playlists>

    @GET("playlistItems")
    suspend fun getItemLists(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("playlistId") id: String,
        @Query("maxResults") maxResults: Int = 20
    ): Response<Playlists>

}