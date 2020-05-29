package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//roles of adapter:1)providing access to data set from datasource for that item
//                 2) creating layout or view for individual items
// Adapter : wraps data set and create views for individual item.

// specify the custom viewHolder which give us access to our view

class ContactAdapter(val contacts: ArrayList<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactItemViewHolder>() {

    // ViewHolder : holds all subviews that depends on current item's data
    // // Must have to add ViewHolder in Adapters

    //provide the direct reference to each of the views with a data item
    //used the cache the views within the item layout for fast access

    // A ViewHolder describes an item view and metadata about its place within the RecyclerView.
    inner class ContactItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variables
        // for any view that will be set as you render a row
        val contactName : TextView = itemView.findViewById(R.id.contact_name_txt)
        val isOnlineBut : TextView = itemView.findViewById(R.id.message_btn)
    }

    // involves inflating a layout from xml and returning the holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactItemViewHolder {
        val context = parent.context
        // inflate the custom layout
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.list_item_layout, parent, false)
        // return a new holder instance
        return ContactItemViewHolder(view)
    }

    // return the total count of the item in the list
    override fun getItemCount(): Int {
        return contacts.size
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ContactItemViewHolder, position: Int) {
        // get the data based on the position
        val contact = contacts.get(position)
//        val textView = holder.contactName
//        textView.setText(contact.name)
        holder.contactName.text = contact.name
        holder.isOnlineBut.text = if (contact.isOnline) "Message" else "offline"
        holder.isOnlineBut.isEnabled = contact.isOnline
    }
}