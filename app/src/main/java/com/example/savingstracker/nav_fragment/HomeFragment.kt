package com.example.savingstracker.nav_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.savingstracker.R
import com.example.savingstracker.bottom_fragment.AccountFragment
import com.example.savingstracker.bottom_fragment.AnalyticsFragment
import com.example.savingstracker.bottom_fragment.CategoryFragment
import com.example.savingstracker.bottom_fragment.WalletFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.bottom_category -> {
                    replaceFragment(CategoryFragment())
                    activity?.title = "Category"
                }
                R.id.bottom_wallet -> {
                    replaceFragment(WalletFragment())
                    activity?.title = "Wallet"
                }
                R.id.bottom_chart-> {
                    replaceFragment(AnalyticsFragment())
                    activity?.title = "Analytics"
                }
                R.id.bottom_account -> {
                    replaceFragment(AccountFragment())
                    activity?.title = "Profile"
                }
            }
            true
        }
        replaceFragment(CategoryFragment())
        activity?.title = "Category"
        bottomNavigationView.selectedItemId = R.id.bottom_category

        val addFab = view.findViewById<FloatingActionButton>(R.id.addFabBtn)
        addFab.setOnClickListener{
            Toast.makeText(context,"Add Ckicked",Toast.LENGTH_LONG).show()
        }
        return view

    }
    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.bottomFragment,fragment)
            .commit()
    }

}