package com.example.yotubeapi1.di

import com.example.yotubeapi1.core.network.networkModules
import com.example.yotubeapi1.data.remote.remoteDataSourceModules


val koinModules = listOf(
    repoModules, viewModules, networkModules, remoteDataSourceModules
)