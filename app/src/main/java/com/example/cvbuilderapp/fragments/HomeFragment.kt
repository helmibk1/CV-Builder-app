package com.example.cvbuilderapp.fragments

import android.R.attr.defaultValue
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvbuilderapp.R
import com.example.cvbuilderapp.adapters.NoteAdapter
import com.example.cvbuilderapp.models.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : Fragment() {

    lateinit var notesRV: RecyclerView
    lateinit var addFAB: FloatingActionButton
    val allNotes = mutableListOf<Note>()
    lateinit var noteRVAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root: View = inflater.inflate(R.layout.fragment_home, container, false)

        notesRV = root.findViewById(R.id.notesRV)
        addFAB = root.findViewById(R.id.idFAB)
        // Inflate the layout for this fragment
        addFAB.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddNoteFragment())
        }
        notesRV.layoutManager = LinearLayoutManager(activity)
        noteRVAdapter = NoteAdapter( ::onDeleteIconClick)
        notesRV.adapter = noteRVAdapter
        val bundle = this.arguments
        if (bundle != null) {
            var noteTitle = bundle.get("noteTitle").toString()
            var noteDescription = bundle.get("noteDescription").toString()
            var note = Note(noteTitle,noteDescription)
            allNotes.add(note)
            noteRVAdapter.updateList(allNotes)
        }
        return root
    }


    fun onDeleteIconClick(note: Note) {
        allNotes.remove(note)
        noteRVAdapter.updateList(allNotes)
        Toast.makeText(activity, "${note.noteTitle} Deleted", Toast.LENGTH_LONG).show()
    }

}