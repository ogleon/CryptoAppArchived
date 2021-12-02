package com.example.p2_cryptoaffinity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.p2_cryptoaffinity.fragments.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment_container, ListFragment())
            setReorderingAllowed(true)
            addToBackStack(null) // name can be null
            commit()
        }


    }
}