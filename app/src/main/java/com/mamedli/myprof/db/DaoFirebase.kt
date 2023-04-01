package com.mamedli.myprof.db

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.mamedli.myprof.entities.PublicationsItem

class DaoFirebase {
    var mainDataBase = MainDataBase()

    fun insertPublication(publication: PublicationsItem){
        mainDataBase.reference.child("publications").child(publication.id).setValue(publication)
    }
}