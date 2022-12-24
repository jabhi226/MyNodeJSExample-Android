package com.example.mynodejsexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.mynodejsexample.R
import com.example.mynodejsexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)
        addFragmentToBackStack(HomeFragment())
    }

    fun replaceFragment(fragment: Fragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.activityMainFrame.id, fragment, fragment::class.java.simpleName)
        ft.commit()
    }

    fun addFragmentToBackStack(fragment: Fragment){
        val ft = supportFragmentManager.beginTransaction()
        ft.add(binding.activityMainFrame.id, fragment, fragment::class.java.simpleName)
        ft.addToBackStack(fragment::class.java.simpleName)
        ft.commit()
    }
}