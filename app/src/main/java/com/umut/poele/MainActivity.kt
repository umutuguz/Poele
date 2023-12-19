package com.umut.poele

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.umut.poele.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    //    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.buttonAdd.setOnClickListener {
            navController.navigate(R.id.addFragment)
//            addFragment.show(supportFragmentManager, AddFragment.TAG)
//            supportFragmentManager.beginTransaction().apply {
//                add(addFragment, AddFragment.TAG)
//
//                addToBackStack(null)
//                commit()
//            }
        }
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//
//
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(binding.navigationBar, navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.homeRecipeDetailFragment ||
                destination.id == R.id.loginFragment ||
                destination.id == R.id.fridgeSupplyFragment ||
                destination.id == R.id.homeRecipeFragment ||
                destination.id == R.id.searchFragment ||
                destination.id == R.id.filterDialog ||
                destination.id == R.id.shopListFragment ||
                destination.id == R.id.addEditRecipeFragment ||
                destination.id == R.id.dailyMenuFragment ||
                destination.id == R.id.shopListFragment ||
                destination.id == R.id.addShopListFragment ||
                destination.id == R.id.favoriteFragment ||
                destination.id == R.id.editProfileFragment ||
                destination.id == R.id.addressFragment ||
                destination.id == R.id.editRecipeFragment ||
                destination.id == R.id.addEditRecipeFragment ||
                destination.id == R.id.addEditSupplyFragment ||
                destination.id == R.id.editSupplyFragment
            ) {
                binding.navigationBar.visibility = View.GONE
                binding.buttonAdd.visibility = View.GONE
            }
            else {
                binding.navigationBar.visibility = View.VISIBLE
                binding.buttonAdd.visibility = View.VISIBLE
            }
        }
//        binding.navigationBar.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.homeFirstFragment -> {setCurrentFragment(HomeFirstFragment())
//                    true}
//                R.id.fridgeFirstFragment -> {
//                    setCurrentFragment(FridgeFirstFragment())
//                    true
//                }
//                R.id.addFragment -> {
//                    addFragment.show(supportFragmentManager, AddFragment.TAG)
//                    false
//                }
//                R.id.macroFirstFragment -> {
//                    setCurrentFragment(MacroFirstFragment())
//                    true
//                }
//                else -> {
//                    setCurrentFragment(ProfileFirstFragment())
//                    true
//                }
//            }
//        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment, fragment)
            addToBackStack(null)
            commit()
        }
    }
}
