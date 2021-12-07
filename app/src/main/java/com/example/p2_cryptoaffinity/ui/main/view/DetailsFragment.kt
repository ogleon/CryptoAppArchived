package com.example.p2_cryptoaffinity.ui.main.view

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.p2_cryptoaffinity.databinding.FragmentDetailsBinding
import com.example.p2_cryptoaffinity.ui.main.viewmodel.TickerViewModel
import com.example.p2_cryptoaffinity.utils.Constants

class DetailsFragment : Fragment() {

    private val model: TickerViewModel by activityViewModels()
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.selectedCoin.observe(viewLifecycleOwner, {
            val coin = it
            Glide.with(this)
                .load(Constants.imageUrl + coin.symbol)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgCoin)

            binding.tvSymbol.text = coin.symbol
            binding.tvNameCoin.text = coin.name
            binding.tv1hValue.text
            binding.tv24hValue.text
            binding.tv7dValue.text
            binding.tvMarketCap.text
            binding.tvCurrencyPrice.text
            binding.tvCirculatingSupply.text = coin.circulatingSupply.toString()
            binding.tvMarketDominance.text = coin.rank.toString()
            binding.tvMaxSupply.text = coin.maxSupply.toString()

            binding.tv1hValue.setTextColor(
                Color.parseColor(
                    when {
                      //  coin.quotes.USD.percent_change_1h.toString().contains("-") -> "#ff0000"
                        else -> "#32CD32"
                    }
                )
            )

            binding.tv24hValue.setTextColor(
                Color.parseColor(
                    when {
                    //    coin.quotes.USD.percent_change_24h.toString().contains("-") -> "#ff0000"
                        else -> "#32CD32"
                    }
                )
            )

            binding.tv7dValue.setTextColor(
                Color.parseColor(
                    when {
                   //     coin.quotes.USD.percent_change_7d.toString().contains("-") -> "#ff0000"
                        else -> "#32CD32"
                    }
                )
            )
        })
    }

}