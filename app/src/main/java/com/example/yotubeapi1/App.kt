package com.example.yotubeapi1

import android.app.Application
import com.example.yotubeapi1.repository.Repository

class App: Application() {

    companion object {

        val repository: Repository by lazy {
            Repository()
        }
    }
}