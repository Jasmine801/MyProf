package com.mamedli.myprof.db

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainDataBase {
    var reference: DatabaseReference = Firebase.database.reference
    var database = FirebaseDatabase.getInstance()
    /*lateinit var reference: DatabaseReference*/
}