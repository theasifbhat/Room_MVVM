package com.skunkworks.roomtake2.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.skunkworks.roomtake2.R
import com.skunkworks.roomtake2.db.Note

class NoteListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<NoteListAdapter.WordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var note = emptyList<Note>() // Cached copy of words

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wordItemView: TextView = itemView.findViewById(R.id.title)
        val wordItemView2: TextView = itemView.findViewById(R.id.note)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current =note[position]
        holder.wordItemView.text = current.title
        holder.wordItemView2.text=current.note

    }

    internal fun setWords(note: List<Note>) {
        this.note = note
        notifyDataSetChanged()
    }

    override fun getItemCount() =note.size
}