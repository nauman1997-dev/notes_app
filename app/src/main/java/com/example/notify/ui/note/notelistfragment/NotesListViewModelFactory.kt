package com.example.notify.ui.note.notelistfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notify.data.repository.NotesListRepo

class NotesListViewModelFactory(
    private val repository: NotesListRepo
) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteListViewModel(repository) as T
    }
}