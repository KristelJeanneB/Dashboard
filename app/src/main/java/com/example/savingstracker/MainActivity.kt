package com.example.savingstracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.savingstracker.bottom_fragment.WalletFragment
import com.example.savingstracker.nav_fragment.AboutFragment
import com.example.savingstracker.nav_fragment.ArchiveFragment
import com.example.savingstracker.nav_fragment.CreategoalFragment
import com.example.savingstracker.nav_fragment.DeleteFragment
import com.example.savingstracker.nav_fragment.HomeFragment
import com.example.savingstracker.nav_fragment.RateFragment
import com.example.savingstracker.nav_fragment.SettingsFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private val onBackPressedCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            onBackPressedMethod()
        }
    }

    private fun onBackPressedMethod() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            (drawerLayout.closeDrawer(GravityCompat.START))
        }else{
            finish()
        }
       
    }

    private lateinit var drawerLayout: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(this,onBackPressedCallback)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)

        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        /// Default Navigation Bar Tab Selected
        replaceFragment(HomeFragment())
        navigationView.setCheckedItem(R.id.nav_home)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navFragment,fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> {
                replaceFragment(HomeFragment())
            }
            R.id.nav_settings -> {
                replaceFragment(SettingsFragment())
                title = "Settings"
            }
            R.id.nav_archive-> {
                replaceFragment(ArchiveFragment())
                title = "Archive"
            }
            R.id.nav_delete -> {
                replaceFragment(DeleteFragment())
                title = "Delete"
            }
            R.id.nav_rate -> {
                replaceFragment(RateFragment())
                title = "Rate Us"
            }
            R.id.nav_about -> {
                replaceFragment(AboutFragment())
                title = "About the App"
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}