package com.example.newsfeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.newsfeed.fragments.fragmentFeedfragment
import com.example.newsfeed.fragments.fragmentProfilefragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Load the default fragment into the container
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragmentFeedfragment())
        fragmentTransaction.commit()

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

//                Toast.makeText(this, "hellow good night", Toast.LENGTH_LONG).show()
            when(item.itemId) {
                R.id.page_1 -> {
                    Toast.makeText(this, "feed selecte", Toast.LENGTH_SHORT ).show()
                    replaceFragment(fragmentFeedfragment())
                    true
                }
                R.id.page_2 -> {
                    Toast.makeText(this, "profile selected", Toast.LENGTH_SHORT).show()
                    replaceFragment(fragmentProfilefragment())
                    true
                }
                else -> false
            }
        }


//        // send user to login page
//        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
//        floatingActionButton.setOnClickListener() {
//            val intent = Intent(this, MainActivity2::class.java)
//            startActivity(intent)
//        }

    }

    private fun replaceFragment(fragment: Fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
        val fragmentManager:FragmentManager = supportFragmentManager
        val fragmentTransaction:FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
    }


}