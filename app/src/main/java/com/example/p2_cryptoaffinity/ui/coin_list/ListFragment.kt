package com.example.p2_cryptoaffinity.ui.coin_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.p2_cryptoaffinity.R
import com.example.p2_cryptoaffinity.data.api.ApiService
import com.example.p2_cryptoaffinity.databinding.FragmentListBinding
import com.example.p2_cryptoaffinity.ui.coin_detail.DetailsFragment
import com.example.p2_cryptoaffinity.ui.coin_list.adapter.CoinAdapter

class ListFragment : Fragment(), CoinAdapter.OnClickListener {
    private lateinit var binding: FragmentListBinding
    private lateinit var coinAdapter: CoinAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private val model: CoinListViewModel by viewModels()

    private lateinit var adapter: CoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getUsers().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(users: List<User>) {
        adapter.apply {
            addUsers(users)
            notifyDataSetChanged()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)

        val ApiService: ApiService =  ApiService.createApiConnection()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        model._coinsList.value = coins

        coinAdapter = CoinAdapter((model._coinsList.value) as MutableList<Coin>, this)
        linearLayoutManager = LinearLayoutManager(context)

        binding.rv.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = coinAdapter
        }

    }

    override fun onItemClick(coin: Coin) {
        model.select(coin)
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.container, DetailsFragment())
            setReorderingAllowed(true)
            addToBackStack(null)
            commit()
        }
    }

}