package com.example.p2_cryptoaffinity.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.p2_cryptoaffinity.R
import com.example.p2_cryptoaffinity.adapter.CoinAdapter
import com.example.p2_cryptoaffinity.adapter.Constants
import com.example.p2_cryptoaffinity.databinding.FragmentListBinding
import com.example.p2_cryptoaffinity.model.Coin
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.*
import java.io.IOException

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_list, container, false)

        return view
    }

}