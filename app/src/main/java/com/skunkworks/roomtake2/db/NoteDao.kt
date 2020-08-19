package com.skunkworks.roomtake2.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun addNote(note: Note)

    @Query("Select * from note")
    fun getAllNotes():LiveData<List<Note>>

    @Insert
   suspend fun addMultipleNotes(vararg note: Note)

}