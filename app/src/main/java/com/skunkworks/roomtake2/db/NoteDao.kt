package com.skunkworks.roomtake2.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Query("Select * from note")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert
    suspend fun addMultipleNotes(vararg note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}