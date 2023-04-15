package com.mamedli.myprof.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.mamedli.myprof.R
import com.mamedli.myprof.databinding.ActivityMainBinding
import com.mamedli.myprof.fragments.CareerFragment
import com.mamedli.myprof.fragments.PublicationsFragment


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    //lateinit var navController: NavController
    val fragment = PublicationsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*val navHostFragment = supportFragmentManager.findFragmentById(R.id.publicationsFragment) as NavHostFragment?
        if (navHostFragment != null) {
            navController = navHostFragment.navController
        }*/

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

    override fun onStart() {
        super.onStart()
        init()
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean{
        if(toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        when(item.itemId){
            R.id.id_public -> {
                transaction.replace(R.id.mainContent, fragment)
                transaction.commit()
            }
            R.id.id_chats -> {

            }
            R.id.id_settings -> {

            }
            R.id.id_career_guidance -> {
                /*val navHostFragment = supportFragmentManager.findFragmentById(R.id.mainContent) as NavHostFragment?
                val navController = navHostFragment?.navController
                navController?.navigate(R.id.careerFragment)*/
                val fragment = CareerFragment()
                transaction.replace(R.id.mainContent, fragment)
                transaction.commit()
                //navController.navigate(R.id.careerFragment)

            }
            R.id.id_my_publications -> {

            }
            R.id.id_account -> {

            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }


}