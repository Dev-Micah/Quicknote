package com.micahnyabuto.note

import android.app.Application

class QuicknoteApplication : Application {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)

    }

}