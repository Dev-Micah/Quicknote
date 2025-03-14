package com.micahnyabuto.note.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDAO(): NoteDao
    companion object{
        @Volatile
        private var Instance: NoteDatabase? = null

        fun getDatabase (context : Context) : NoteDatabase{
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, NoteDatabase::class.java,"note_database")
                    .build()
                    .also { Instance= it }
            }
        }
    }

}