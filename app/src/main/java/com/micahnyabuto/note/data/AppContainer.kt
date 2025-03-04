package com.micahnyabuto.note.data

import android.content.Context

interface AppContainer{
    val notesRepository: NotesRepository
}

class AppDataContainer(private val context: Context): AppContainer{

    override val notesRepository: NotesRepository by lazy {
        OfflineNotesRepository()
    }



}