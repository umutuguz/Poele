package com.umut.poele

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.umut.poele.databinding.ActivityMainBinding
import com.umut.poele.ui.add.AddFragment
import com.umut.poele.ui.fridge.FridgeFirstFragment
import com.umut.poele.ui.home.HomeFirstFragment
import com.umut.poele.ui.macro.MacroFirstFragment
import com.umut.poele.ui.profile.ProfileFirstFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

//        NavigationUI.setupWithNavController(binding.navigationBar, navController)
        binding.navigationBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFirstFragment -> {setCurrentFragment(HomeFirstFragment())
                    true}
                R.id.fridgeFirstFragment -> {
                    setCurrentFragment(FridgeFirstFragment())
                    true
                }
                R.id.addFragment -> {
                    addFragment.show(supportFragmentManager, AddFragment.TAG)
                    false
                }
                R.id.macroFirstFragment -> {
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
//            addToBackStack(null)
            commit()
        }
    }
}
