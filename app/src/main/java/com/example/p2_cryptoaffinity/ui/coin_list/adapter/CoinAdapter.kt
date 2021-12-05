package com.example.p2_cryptoaffinity.ui.coin_list.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.p2_cryptoaffinity.R
import com.example.p2_cryptoaffinity.utils.Constants
import com.example.p2_cryptoaffinity.databinding.ItemCryptoBinding

class CoinAdapter(private val coins: MutableList<Coin>, private val listener: OnClickListener) :
    RecyclerView.Adapter<CoinAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_crypto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val coin = coins[position]

        with(holder) {
            setListener(coin)
            Glide.with(context)
                .load(Constants.imageUrl + "${coin.name}-${coin.symbol}-logo.svg?v=014")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgCoin)

            binding.tvSymbol.text = coin.symbol
            binding.tvNameCoin.text = coin.name
            binding.tv1hValue.text = coin.quotes.USD.percent_change_1h.toString().plus("%")
            binding.tv24hValue.text = coin.quotes.USD.percent_change_24h.toString().plus("%")
            binding.tv7dValue.text = coin.quotes.USD.percent_change_7d.toString().plus("%")

            binding.tv1hValue.setTextColor(
                Color.parseColor(
                    when {
                        coin.quotes.USD.percent_change_1h.toString().contains("-") -> "#ff0000"
                        else -> "#32CD32"
                    }
                )
            )

            binding.tv24hValue.setTextColor(
                Color.parseColor(
                    when {
                        coin.quotes.USD.percent_change_24h.toString().contains("-") -> "#ff0000"
                        else -> "#32CD32"
                    }
                )
            )

            binding.tv7dValue.setTextColor(
                Color.parseColor(
                    when {
                        coin.quotes.USD.percent_change_7d.toString().contains("-") -> "#ff0000"
                        else -> "#32CD32"
                    }
                )
            )

        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemCryptoBinding.bind(view)

        fun setListener(coin: Coin) {
            binding.root.setOnClickListener {
                listener.onItemClick(coin)
            }
        }

    }

    override fun getItemCount(): Int {
        return coins.size
    }

    interface OnClickListener {
        fun onItemClick(coin: Coin)
    }
}




