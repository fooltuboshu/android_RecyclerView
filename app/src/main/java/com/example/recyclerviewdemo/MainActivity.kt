package com.example.recyclerviewdemo

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize contacts
        val contacts = Contact.createContactList(30)
        val recyclerView = findViewById<RecyclerView>(R.id.rcy_view)
        // create the adapter using the sample user data
        val adapter = ContactAdapter(contacts)
        // attach the adapter to the recycle views to populate items
        recyclerView.adapter = adapter
        // Set LayoutManager to position the items
        //A LayoutManager is responsible for measuring and positioning item views within a RecyclerView
        // as well as determining the policy for when to recycle item views that are no longer visible to the user.

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
//        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val dividerDrawable =
            ContextCompat.getDrawable(this, R.drawable.divider) as Drawable

        recyclerView.addItemDecoration(Divider(dividerDrawable))
    }
}
