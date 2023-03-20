package com.example.yotubeapi1.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.yotubeapi1.core.network.results.Resource
import com.example.yotubeapi1.data.remote.RemoteDataSource
import com.example.yotubeapi1.data.remote.model.Playlists
import kotlinx.coroutines.Dispatchers

class Repository {

 private val dataSource: RemoteDataSource by lazy {
     RemoteDataSource()
 }

     fun getPlaylists(): LiveData<Resource<Playlists>>{
         return liveData(Dispatchers.IO){
             emit(Resource.loading())
             val response = dataSource.getPlaylists()
             emit(response)
         }
     }

    fun getItemLists(id: String): LiveData<Resource<Playlists>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val response = dataSource.getItemplaylists(id)
            emit(response)

        }
    }
 }


