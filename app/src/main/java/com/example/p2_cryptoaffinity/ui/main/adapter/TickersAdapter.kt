package com.example.p2_cryptoaffinity.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.p2_cryptoaffinity.R
import com.example.p2_cryptoaffinity.data.model.TickerEntity
import com.example.p2_cryptoaffinity.databinding.ItemCryptoBinding
import com.example.p2_cryptoaffinity.utils.Constants


class TickersAdapter(
    private val coins: MutableList<TickerEntity>,
    private val listener: OnClickListener
) :
    RecyclerView.Adapter<TickersAdapter.ViewHolder>() {

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

                .load(Constants.imageUrl + coin.symbol)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgCoin)


            binding.tvSymbol.text = coin.symbol
            binding.tvNameCoin.text = coin.name
            binding.tvCurrencyPrice.text = coin.quotes!!["USD"]?.price.toString()
            binding.tv1hValue.text = coin.quotes!!["USD"]?.percentChange1h.toString()
            binding.tv24hValue.text = coin.quotes!!.get("USD")?.percentChange24h.toString()
            binding.tv7dValue.text
        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemCryptoBinding.bind(view)

        fun setListener(coin: TickerEntity) {
            binding.root.setOnClickListener {
                listener.onClick(coin)
            }
        }

    }

    override fun getItemCount(): Int {
        return coins.size
    }

    interface OnClickListener {
        fun onClick(coin: TickerEntity)
    }

    fun addCoins(coins: List<TickerEntity>) {
        this.coins.apply {
            clear()
            addAll(coins)
        }

    }
}