package com.mamedli.myprof.db

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase



class MainDataBase {
    var database = FirebaseDatabase.getInstance()
    lateinit var reference: DatabaseReference
}