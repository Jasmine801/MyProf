package com.mamedli.myprof.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.view.menu.MenuBuilder
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.mamedli.myprof.R
import com.mamedli.myprof.activities.MainActivity
import com.mamedli.myprof.databinding.FragmentNewPublicationBinding
import com.mamedli.myprof.databinding.FragmentPublicationsBinding
import com.mamedli.myprof.db.DaoFirebase
import com.mamedli.myprof.db.MainDataBase
import com.mamedli.myprof.entities.PublicationsItem
import com.mamedli.myprof.entities.User


class NewPublicationFragment : Fragment(), MenuProvider {

    var dao = DaoFirebase()
    private var database: DatabaseReference = FirebaseDatabase.getInstance("https://myprofvol2-default-rtdb.firebaseio.com/")
        .getReference("publications")
    lateinit var binding: FragmentNewPublicationBinding
    lateinit var user: User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewPublicationBinding.inflate(inflater, container, false)
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewPublicationFragment()
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
       menuInflater.inflate(R.menu.new_publication_menu, menu)
    }


    private fun actionBarSettings(){
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    private fun createNewPublication() : PublicationsItem{
        return PublicationsItem(
            database.key.toString(),
            binding.edTitle.text.toString(),
            binding.edDescription.text.toString(),
            "0"
        )
    }

    private fun setCreateResult(){
        val publication = createNewPublication()
        //database = FirebaseDatabase.getInstance().getReference("publications")
        //database.child("publications").child(publication.id).setValue(publication)
        //publication.id?.let { database.child(it).push().setValue(publication) }
        database.push().setValue(publication)
        //dao.insertPublication(publication)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        val controller = findNavController()
        return when (menuItem.itemId) {
            R.id.id_save -> {
                setCreateResult()
                controller.navigate(R.id.publicationsFragment)
                true
            }
            else -> false
        }
    }
}