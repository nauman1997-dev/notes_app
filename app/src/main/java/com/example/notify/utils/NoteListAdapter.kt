package com.example.notify.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notify.R
import com.example.notify.data.database.entities.Note
import kotlinx.android.synthetic.main.notes_list_layout.view.*

class NoteListAdapter(
    var items: List<Note>
) : RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.notes_list_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = items[position]
        holder.itemView.title_text.text = currentNote.title
        holder.itemView.note_txt.text = currentNote.note
        holder.itemView.date_txt.text = currentNote.date
    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}