package com.mamedli.myprof.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mamedli.myprof.R
import com.mamedli.myprof.databinding.FragmentPublicationsBinding


class PublicationsFragment : Fragment() {

    lateinit var binding: FragmentPublicationsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPublicationsBinding.inflate(inflater, container, false)
        onClickNewPublication()
        return binding.root

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