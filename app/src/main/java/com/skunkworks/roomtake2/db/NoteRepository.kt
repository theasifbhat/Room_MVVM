package com.skunkworks.roomtake2.db

import androidx.lifecycle.LiveData

class NoteRepository(private val dao: NoteDao){

 val notes:LiveData<List<Note>> = dao.getAllNotes()

 suspend fun insertNote(note: Note){
     dao.addNote(note)
 }


}