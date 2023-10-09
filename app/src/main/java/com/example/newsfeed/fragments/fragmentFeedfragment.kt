package com.example.newsfeed.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsfeed.MainActivity
import com.example.newsfeed.MainActivity2
import com.example.newsfeed.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class fragmentFeedfragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_feedfragment, container, false)
        // send user to login page
        val floatingActionButton = rootView.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener() {

            val intent = Intent(activity, MainActivity2::class.java)
            startActivity(intent)
        }

        return rootView
    }

}