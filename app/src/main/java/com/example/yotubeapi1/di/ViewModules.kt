package com.example.yotubeapi1.di


import com.example.yotubeapi1.ui.itemplaylists.adapter.ItemViewModel
import com.example.yotubeapi1.ui.playlists.adapter.PlaylistsViewModel
import com.example.yotubeapi1.ui.videolists.adapter.VideoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModules = module {
    viewModel { PlaylistsViewModel(get()) }
    viewModel { ItemViewModel(get()) }
    viewModel { VideoViewModel(get()) }
}