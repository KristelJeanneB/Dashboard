package com.example.savingstracker.nav_fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import com.example.savingstracker.R
import com.example.savingstracker.bottom_fragment.AccountFragment
import com.example.savingstracker.bottom_fragment.RecommendationsFragment
import com.example.savingstracker.bottom_fragment.CategoryFragment
import com.example.savingstracker.bottom_fragment.CreategoalFragment
import com.example.savingstracker.bottom_fragment.WalletFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

    class HomeFragment : Fragment() {


        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_home, container, false)

            val bottomNavigationView =
                view.findViewById<BottomNavigationView>(R.id.bottomNavigation)
            bottomNavigationView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.bottom_category -> {
                        replaceFragment(CategoryFragment())
                        activity?.title = "Home"
                        true
                    }

                    R.id.bottom_wallet -> {
                        replaceFragment(WalletFragment())
                        activity?.title = "Wallet"
                        true
                    }

                    R.id.bottom_add -> {
                        replaceFragment(CreategoalFragment())
                        activity?.title = "Create Goal"
                        true
                    }

                    R.id.bottom_chart -> {
                        replaceFragment(RecommendationsFragment())
                        activity?.title = "Recommendations"
                        true
                    }

                    R.id.bottom_account -> {
                        replaceFragment(AccountFragment())
                        activity?.title = "Account"
                        true
                    }
                }
                true
            }
            return view
        }


        private fun startActivity(intent: Unit) {

        }

        private fun replaceFragment(fragment: Fragment) {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.bottomFragment, fragment)
                .commit()
        }
    }
