package com.example.notify.ui.note.notelistfragment

import androidx.lifecycle.ViewModel
import com.example.notify.data.database.entities.Note
import com.example.notify.data.repository.NotesListRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteListViewModel(
    private val repository: NotesListRepo
) : ViewModel() {

    fun getAllNotes() = repository.getAllNotes()
}