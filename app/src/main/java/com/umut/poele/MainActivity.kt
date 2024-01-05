package com.umut.poele

import android.annotation.SuppressLint
import android.os.Bundle
import android.service.notification.Condition
import android.view.View
import android.window.SplashScreen
import android.window.SplashScreenView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.firebase.BuildConfig
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.umut.poele.databinding.ActivityMainBinding
import com.umut.poele.ui.login.LoginViewModel
import com.umut.poele.util.Constant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition{
            false
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.buttonAdd.setOnClickListener {
            navController.navigate(R.id.addFragment)

        }

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

    }

}
