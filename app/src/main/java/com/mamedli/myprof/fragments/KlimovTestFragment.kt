package com.mamedli.myprof.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.mamedli.myprof.R
import com.mamedli.myprof.databinding.FragmentKlimovTestBinding

class KlimovTestFragment : Fragment() {

    lateinit var binding: FragmentKlimovTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKlimovTestBinding.inflate(inflater, container, false)
        binding.bStartTest.setOnClickListener { onClickStartTest() }
        return binding.root
    }

    private fun onClickStartTest(){
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://ya.ru")))
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            KlimovTestFragment()
    }
}