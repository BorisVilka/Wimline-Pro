package com.wimlime.pro

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavController.OnDestinationChangedListener
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.wimlime.pro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.inc.toolbar)
        val navHostFragment = binding.inc.fragmentContainerView.getFragment() as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.nav,navController)
        NavigationUI.setupWithNavController(binding.inc.toolbar,navController)
        val toggle = ActionBarDrawerToggle(
            this,
            binding.draw,
            binding.inc.toolbar,
            R.string.app_name,
            R.string.app_name
        )
        binding.draw.addDrawerListener(toggle)
        binding.inc.toolbar.title = ""
        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        toggle.isDrawerIndicatorEnabled = true
        toggle.syncState()
        supportActionBar!!.title = ""
        binding.draw.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {

            }

            override fun onDrawerOpened(drawerView: View) {

            }

            override fun onDrawerClosed(drawerView: View) {

            }

            override fun onDrawerStateChanged(newState: Int) {

            }

        })
        navController.addOnDestinationChangedListener(OnDestinationChangedListener { navController: NavController?, navDestination: NavDestination, bundle: Bundle? ->
            toggle.syncState()
        })
        binding.imageView.setOnClickListener {
            binding.draw.close()
        }
        binding.events.setOnClickListener {
            if(navController.currentDestination!!.id!=R.id.matchesFragment) navController.navigate(R.id.matchesFragment)
            binding.draw.close()
        }
        binding.imageView2.setOnClickListener {
            if(navController.currentDestination!!.id!=R.id.matchesFragment) navController.navigate(R.id.matchesFragment)
            binding.draw.close()
        }
        binding.events2.setOnClickListener {
            if(navController.currentDestination!!.id!=R.id.playersFragment) navController.navigate(R.id.playersFragment)
            binding.draw.close()
        }
        binding.imageView3.setOnClickListener {
            if(navController.currentDestination!!.id!=R.id.playersFragment) navController.navigate(R.id.playersFragment)
            binding.draw.close()
        }
        binding.events3.setOnClickListener {
            if(navController.currentDestination!!.id!=R.id.teamFragment) navController.navigate(R.id.teamFragment)
            binding.draw.close()
        }
        binding.imageView4.setOnClickListener {
            if(navController.currentDestination!!.id!=R.id.teamFragment) navController.navigate(R.id.teamFragment)
            binding.draw.close()
        }
    }
}