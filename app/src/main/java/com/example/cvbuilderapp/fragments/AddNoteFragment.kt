package com.example.cvbuilderapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.cvbuilderapp.R

class AddNoteFragment : Fragment() {

    lateinit var noteTitleEdt: EditText
    lateinit var noteEdt: EditText
    lateinit var saveBtn: Button

    var noteID = -1;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteTitleEdt = requireView().findViewById(R.id.idEdtNoteName)
        noteEdt = requireView().findViewById(R.id.idEdtNoteDesc)
        saveBtn = requireView().findViewById(R.id.backBt)


        // on below line we are adding
        // click listener to our save button.
        saveBtn.setOnClickListener {
            val noteTitle = noteTitleEdt.text.toString()
            val noteDescription = noteEdt.text.toString()

            if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                Toast.makeText(activity, "New Note Added", Toast.LENGTH_LONG).show()
            }
            findNavController().navigate(AddNoteFragmentDirections.actionAddNoteFragmentToHomeFragment(noteTitle,noteDescription))
        }


    }



}