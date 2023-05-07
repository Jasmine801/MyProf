package com.mamedli.myprof.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.mamedli.myprof.R
import com.mamedli.myprof.databinding.ActivityMainBinding
import com.mamedli.myprof.fragments.CareerFragment
import com.mamedli.myprof.fragments.NewPublicationFragment
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
                val fragment = PublicationsFragment()
                transaction.replace(R.id.mainContent, fragment)
                transaction.commit()
                /*var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)*/
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
                /*var intent = Intent(this, CareerActivity::class.java)
                startActivity(intent)*/

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