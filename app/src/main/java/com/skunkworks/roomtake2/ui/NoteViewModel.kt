package com.skunkworks.roomtake2.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.skunkworks.roomtake2.db.Note
import com.skunkworks.roomtake2.db.NoteDatabase
import com.skunkworks.roomtake2.db.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) :AndroidViewModel(application) {

    private var repository:NoteRepository
      var allWords:LiveData<List<Note>>

            init{
                val dao = NoteDatabase.getDatabase(application).noteDao()
                repository= NoteRepository(dao)
                allWords=repository.notes
            }

    fun insert(note: Note)=viewModelScope.launch(Dispatchers.IO) {
        repository.insertNote(note)
    }
    fun deleteNote(note: Note)= viewModelScope.launch(Dispatchers.IO) {
        repository.deleteNote(note)
    }



}