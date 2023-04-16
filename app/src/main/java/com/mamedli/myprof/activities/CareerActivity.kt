package com.mamedli.myprof.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import com.mamedli.myprof.R
import com.mamedli.myprof.databinding.ActivityCareerBinding
import com.mamedli.myprof.databinding.ActivityNewPublicationBinding

class CareerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCareerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCareerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun init(){
        toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, R.string.open, R.string.close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navView.setNavigationItemSelectedListener(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
}