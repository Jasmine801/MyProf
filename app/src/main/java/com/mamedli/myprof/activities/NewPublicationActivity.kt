package com.mamedli.myprof.activities

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mamedli.myprof.R
import com.mamedli.myprof.databinding.ActivityNewPublicationBinding
import com.mamedli.myprof.databinding.FragmentCareerBinding

class NewPublicationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewPublicationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPublicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}