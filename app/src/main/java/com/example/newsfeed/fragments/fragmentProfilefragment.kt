package com.example.newsfeed.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.newsfeed.R
import com.google.android.material.snackbar.Snackbar

class fragmentProfilefragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_profilefragment, container, false)

        val imageButton_notification = rootView.findViewById<ImageButton>(R.id.profile_notification_button)

        //creating a object to call the java methods
        val java_obj = fragmentProfilefragment_java()
//        java_obj.showActionbar(imageButton_notification, "Notification is on for this profile", requireView())

        java_obj.main()
//        java_obj.showActionbar("vishwas babar", requireView())

        imageButton_notification.setOnClickListener(){
            Snackbar.make(requireView(), "Notification is on.", Snackbar.LENGTH_SHORT ).show()
        }


        return rootView
    }


}