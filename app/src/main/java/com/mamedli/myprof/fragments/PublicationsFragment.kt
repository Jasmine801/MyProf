package com.mamedli.myprof.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import com.mamedli.myprof.R
import com.mamedli.myprof.adapters.PublicationsAdapter
import com.mamedli.myprof.databinding.FragmentPublicationsBinding
import com.mamedli.myprof.db.MainDataBase
import com.mamedli.myprof.db.MainViewModel
import com.mamedli.myprof.entities.PublicationsItem


class PublicationsFragment : Fragment() {

    lateinit var binding: FragmentPublicationsBinding
    var database: DatabaseReference = FirebaseDatabase.getInstance("https://myprof-1ac73-default-rtdb.firebaseio.com/")
        .getReference("publications")
    private lateinit var publicationsArrayList: ArrayList<PublicationsItem>
    //var adapter = PublicationsAdapter(publicationsArrayList)


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
        //initRcView()
        binding.rcViewPublic.layoutManager = LinearLayoutManager(activity)
        binding.rcViewPublic.setHasFixedSize(true)
        publicationsArrayList = arrayListOf<PublicationsItem>()
        //binding.rcViewPublic.adapter = adapter

        getPublicationsData()

    }

    private fun initRcView() = with(binding){
        rcViewPublic.layoutManager = LinearLayoutManager(activity)
        rcViewPublic.setHasFixedSize(true)
        publicationsArrayList = arrayListOf<PublicationsItem>()


        //getPublicationsData()
    }

    private fun getPublicationsData() {
        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(publicSnapshot in snapshot.children){
                        val publication = publicSnapshot.getValue(PublicationsItem::class.java)
                        publicationsArrayList.add(publication!!)
                    }
                }
                binding.rcViewPublic.adapter = PublicationsAdapter(publicationsArrayList)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
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