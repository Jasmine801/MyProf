package com.mamedli.myprof.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mamedli.myprof.R
import com.mamedli.myprof.databinding.FragmentCareerBinding


class CareerFragment : Fragment() {

    lateinit var binding: FragmentCareerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCareerBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickCareerGuidance()
    }

    companion object {
        @JvmStatic
        fun newInstance() = CareerFragment()
    }

    private fun onClickCareerGuidance(){
        /*val controller = findNavController()
        binding.clKlimov.setOnClickListener {
            controller.navigate(R.id.klimovTestFragment)
        }*/
        /*var intent = Intent(activity, ChatActivity::class.java)
        binding.clKlimov.setOnClickListener { startActivity(intent) }*/
        binding.clKlimov.setOnClickListener {
            childFragmentManager.beginTransaction().apply {
                replace(R.id.careerFragment, KlimovTestFragment())
                commit()
            }
        }

    }
}