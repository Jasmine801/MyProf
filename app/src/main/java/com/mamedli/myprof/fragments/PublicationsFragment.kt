package com.mamedli.myprof.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.mamedli.myprof.R
import com.mamedli.myprof.adapters.PublicationsAdapter
import com.mamedli.myprof.databinding.FragmentPublicationsBinding
import com.mamedli.myprof.db.MainDataBase
import com.mamedli.myprof.db.MainViewModel
import com.mamedli.myprof.entities.PublicationsItem


class PublicationsFragment : Fragment() {

    lateinit var binding: FragmentPublicationsBinding
    lateinit var adapter: PublicationsAdapter
    val dataBase = MainDataBase()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentPublicationsBinding.inflate(inflater, container, false)
        onClickNewPublication()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
    }

    private fun initRcView() = with(binding){
        rcViewPublic.layoutManager = LinearLayoutManager(activity)
        adapter = PublicationsAdapter()
        rcViewPublic.adapter = adapter
        changeListener()
    }

    private fun changeListener(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val publication = dataSnapshot.getValue<PublicationsItem>()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("TAG", "loadPost:onCancelled", databaseError.toException())
            }
        }
        dataBase.reference.addValueEventListener(postListener)
    }

    private fun onClickNewPublication(){
        val controller = findNavController()
        binding.ibAddPublication.setOnClickListener {
            controller.navigate(R.id.newPublicationFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = PublicationsFragment()
    }
}