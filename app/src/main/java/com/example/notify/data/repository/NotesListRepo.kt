package com.example.notify.data.repository

import androidx.lifecycle.LiveData
import com.example.notify.data.database.NoteDatabase
import com.example.notify.data.database.entities.Note

class NotesListRepo(
    private val db: NoteDatabase
) {
    fun getAllNotes(): LiveData<List<Note>> = db.getNoteDao().getAllNotes()
}