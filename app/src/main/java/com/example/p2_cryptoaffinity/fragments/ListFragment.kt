package com.example.p2_cryptoaffinity.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.p2_cryptoaffinity.CoinViewModel
import com.example.p2_cryptoaffinity.adapter.CryptoListAdapter
import com.example.p2_cryptoaffinity.databinding.FragmentListBinding
import com.example.p2_cryptoaffinity.retrofit.Coin


class ListFragment : Fragment() {


    lateinit var adapter: CryptoListAdapter
    lateinit var listCoins: List<Coin>
    lateinit var binding: FragmentListBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val coinViewModel: CoinViewModel by viewModels()

        listCoins = coinViewModel.listCoins.value!!
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =
            inflater.inflate(com.example.p2_cryptoaffinity.R.layout.fragment_list, container, false)

        binding = FragmentListBinding.inflate(layoutInflater)

        adapter = CryptoListAdapter(listCoins)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(context)

        return view
    }


}