package com.example.p2_cryptoaffinity.presentation.coin_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.p2_cryptoaffinity.databinding.FragmentListBinding
import com.example.p2_cryptoaffinity.domain.model.Coin
import com.example.p2_cryptoaffinity.presentation.coin_list.adapter.CoinAdapter

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var coinAdapter: CoinAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private val model: CoinListViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coinAdapter = CoinAdapter(model.state.value.coins)
        linearLayoutManager = LinearLayoutManager(context)

        binding.rv.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = coinAdapter
        }


       // binding.fabAdd.setOnClickListener {
       //     parentFragmentManager.beginTransaction().apply {
         //       replace(R.id.fragmentContainerView, NewUserFragment())
           //     setReorderingAllowed(true)
             //   addToBackStack(null)
               // commit()
           // }
       // }


    }

    override fun onClick(coin: Coin) {
        model.select(user)
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView, DetailFragment())
            setReorderingAllowed(true)
            addToBackStack(null)
            commit()
        }
    }


}