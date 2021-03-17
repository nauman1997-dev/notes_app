package com.example.notify.ui.note.notelistfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.notify.R
import com.example.notify.data.database.NoteDatabase
import com.example.notify.data.repository.NotesListRepo
import com.example.notify.utils.NoteListAdapter
import kotlinx.android.synthetic.main.note_list_fragment.*


class NoteListFragment : Fragment() {

    private lateinit var viewModel: NoteListViewModel
    private lateinit var adapter: NoteListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.note_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val database = NoteDatabase(requireContext())
        val repository = NotesListRepo(database)
        val factory = NotesListViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(NoteListViewModel::class.java)

        adapter = NoteListAdapter(listOf())
        notes_list.layoutManager = GridLayoutManager(requireContext(), 2);
        notes_list.adapter = adapter

        if (adapter.items.isEmpty()) {
            notes_list.visibility = View.GONE
            empty_txt.visibility = View.VISIBLE
        } else {
            notes_list.visibility = View.VISIBLE
            empty_txt.visibility = View.GONE
        }

        bookmark_icon.setOnClickListener {
        }

        add_note_btn.setOnClickListener {
            findNavController().navigate(R.id.action_noteListFragment_to_addNoteFragment)
        }

        viewModel.getAllNotes().observe(viewLifecycleOwner, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
    }
}