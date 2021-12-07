package com.example.p2_cryptoaffinity.ui.main.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.util.Log.VERBOSE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.p2_cryptoaffinity.BuildConfig.DEBUG
import com.example.p2_cryptoaffinity.R
import com.example.p2_cryptoaffinity.data.api.ApiHelper
import com.example.p2_cryptoaffinity.data.api.RetrofitBuilder
import com.example.p2_cryptoaffinity.data.model.Coin
import com.example.p2_cryptoaffinity.data.model.TickerEntity
import com.example.p2_cryptoaffinity.databinding.FragmentListBinding
import com.example.p2_cryptoaffinity.ui.base.ViewModelFactory
import com.example.p2_cryptoaffinity.ui.main.adapter.TickersAdapter
import com.example.p2_cryptoaffinity.ui.main.viewmodel.TickerViewModel
import com.example.p2_cryptoaffinity.utils.Status

class ListFragment : Fragment(), TickersAdapter.OnClickListener {

    private lateinit var viewModel: TickerViewModel
    private lateinit var adapter: TickersAdapter
    private lateinit var binding: FragmentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        setupUI()
        setupObservers()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root

    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(TickerViewModel::class.java)
    }

    private fun setupUI() {
        binding.rv.layoutManager = LinearLayoutManager(context)
        adapter = TickersAdapter(arrayListOf(), this)
        binding.rv.adapter = adapter
    }

    private fun setupObservers() {

        viewModel.getCoins().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        binding.rv.visibility = View.VISIBLE
                        binding.rvProgressBar.visibility = View.GONE
                        resource.data?.let { coins -> retrieveList(coins)  }
                    }
                    Status.ERROR -> {
                        binding.rv.visibility = View.VISIBLE
                        binding.rvProgressBar.visibility = View.GONE
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        binding.rvProgressBar.visibility = View.VISIBLE
                        binding.rv.visibility = View.GONE
                    }
                }
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun retrieveList(coins: List<TickerEntity>) {
        adapter.apply {
            addCoins(coins)
            notifyDataSetChanged()
        }
    }

    override fun onClick(coin: TickerEntity) {
        viewModel.select(coin)
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.container, DetailsFragment())
            setReorderingAllowed(true)
            addToBackStack(null)
            commit()
        }

    }

}