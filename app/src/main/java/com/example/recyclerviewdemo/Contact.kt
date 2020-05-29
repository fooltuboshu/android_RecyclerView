package com.example.recyclerviewdemo

// create a class used as datasource for individual item
class Contact (val name: String, val isOnline: Boolean) {
    companion object {
        fun createContactList(numberLimit: Int ) : ArrayList<Contact> {
            var contacts = ArrayList<Contact>()
            for (i in 1 .. numberLimit) {
                contacts.add(Contact("Person"+ i, i % 2 == 0))
            }
            return contacts
        }
    }
}