package com.kz.valocheck

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kz.valocheck.databinding.ActivityMainBinding
import com.kz.valocheck.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val binding by viewBinding(ActivityMainBinding::inflate)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)


        val bottomNavigation : BottomNavigationView = binding.bottomNavigation

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        bottomNavigation.setupWithNavController(navController)

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.agentsFragment,R.id.mapsFragment,R.id.weaponsFragment))
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        val switch = binding.darkModeSwitch
        switch.isChecked = DarkModeHelper.getInstance(applicationContext).isDark()
        switch.setOnClickListener{
            DarkModeHelper.getInstance(applicationContext).toggleDark()
        }



    }





}