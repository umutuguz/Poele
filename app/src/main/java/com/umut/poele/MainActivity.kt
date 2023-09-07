package com.umut.poele

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.umut.poele.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val addFragment = AddFragment()

        binding.navigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {setCurrentFragment(HomeFirstFragment())
                    true}
                R.id.fridge -> {
                    setCurrentFragment(FridgeFirstFragment())
                    true
                }
                R.id.add -> {
                    addFragment.show(supportFragmentManager, AddFragment.TAG)
                    false
                }
                R.id.macro -> {
                    setCurrentFragment(MacroFirstFragment())
                    true
                }
                else -> {
                    setCurrentFragment(ProfileFirstFragment())
                    true
                }
            }
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment, fragment)
            commit()
        }
    }
}
