package com.example.newsfeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

//                Toast.makeText(this, "hellow good night", Toast.LENGTH_LONG).show()
            when(item.itemId) {
                R.id.page_1 -> {
                    Toast.makeText(this, "feed selecte", Toast.LENGTH_SHORT ).show()
                    true
                }
                R.id.page_2 -> {
                    Toast.makeText(this, "profile selected", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }


        // send user to login pag
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener() {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }


}