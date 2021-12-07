package com.example.p2_cryptoaffinity.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.p2_cryptoaffinity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}