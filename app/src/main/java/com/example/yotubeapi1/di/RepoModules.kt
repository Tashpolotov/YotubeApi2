package com.example.yotubeapi1.di

import com.example.yotubeapi1.repository.Repository
import org.koin.dsl.module


val repoModules = module {
    single { Repository(get()) }
}