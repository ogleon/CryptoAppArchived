package com.example.p2_cryptoaffinity.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.p2_cryptoaffinity.R
import com.example.p2_cryptoaffinity.data.model.TickerEntity
import com.example.p2_cryptoaffinity.databinding.ItemCryptoBinding


class TickersAdapter(private val coins: MutableList<TickerEntity>, private val listener: OnClickListener) :
    RecyclerView.Adapter<TickersAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_crypto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val tickerEntity = coins[position]

        with(holder) {
            setListener(tickerEntity)
            com.bumptech.glide.Glide.with(context)
                .load(com.example.p2_cryptoaffinity.utils.Constants.imageUrl + "${tickerEntity.name}-${tickerEntity.symbol}-logo.svg?v=014")
                .diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.imgCoin)

            binding.tvSymbol.text = tickerEntity.symbol
            binding.tvNameCoin.text = tickerEntity.name
            binding.tv1hValue.text = tickerEntity.quotes?.get("percentChange1h").toString().plus("%")
            binding.tv24hValue.text = tickerEntity.quotes?.get("percentChange24h").toString().plus("%")
            binding.tv7dValue.text = tickerEntity.quotes?.get("percentChange7d").toString().plus("%")

            binding.tv1hValue.setTextColor(
                android.graphics.Color.parseColor(
                    when {
                        tickerEntity.quotes?.get("percentChange1h").toString().contains("-") -> "#ff0000"
                        else -> "#32CD32"
                    }
                )
            )

            binding.tv24hValue.setTextColor(
                android.graphics.Color.parseColor(
                    when {
                        tickerEntity.quotes?.get("percentChange24h").toString().contains("-") -> "#ff0000"
                        else -> "#32CD32"
                    }
                )
            )

            binding.tv7dValue.setTextColor(
                android.graphics.Color.parseColor(
                    when {
                        tickerEntity.quotes?.get("percentChange7d").toString().contains("-") -> "#ff0000"
                        else -> "#32CD32"
                    }
                )
            )

        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemCryptoBinding.bind(view)

        fun setListener(tickerEntity: TickerEntity) {
            binding.root.setOnClickListener {
                listener.onClick(tickerEntity)
            }
        }

    }

    override fun getItemCount(): Int {
        return coins.size
    }

    interface OnClickListener {
        fun onClick(tickerEntity: TickerEntity)
    }

    fun addTickers(users: List<TickerEntity>) {
        this.coins.apply {
            clear()
            addAll(users)
        }

    }
}