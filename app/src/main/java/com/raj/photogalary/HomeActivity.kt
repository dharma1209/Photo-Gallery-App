package com.raj.photogalary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.raj.photogalary.databinding.ActivityHomeBinding
import com.raj.photogalary.fragments.CategoryFragment
import com.raj.photogalary.fragments.HomeFragment
import com.raj.photogalary.fragments.SettingFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var homeBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        supportActionBar?.title = "Photo Galary"
        supportActionBar?.setHomeButtonEnabled(true)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment()).commit()
        homeBinding.navView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.category -> replaceFragment(CategoryFragment())
                R.id.setting -> replaceFragment(SettingFragment())
                else -> Toast.makeText(this,"Invalid Touch", Toast.LENGTH_SHORT).show()
            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
    }

}