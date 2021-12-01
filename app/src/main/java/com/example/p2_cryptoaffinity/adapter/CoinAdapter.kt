package com.example.p2_cryptoaffinity.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.p2_cryptoaffinity.R
import com.example.p2_cryptoaffinity.databinding.ItemCryptoBinding
import com.example.p2_cryptoaffinity.interfaces.OnClickListener
import com.example.p2_cryptoaffinity.model.Coin
import com.squareup.picasso.Picasso
import java.util.*

class CoinAdapter(
    private val listener: OnClickListener
) : RecyclerView.Adapter<CoinAdapter.ViewHolder>() {


    private lateinit var listCoins: MutableList<Coin>

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_crypto, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val c = listCoins[position]
        with(holder) {
            setListener(c)
            binding.imgCoin.imageAlpha = c.id.toInt()
            binding.tvSymbol.text = c.symbol
            binding.tvNameCoin.text = c.name
            binding.tv1hValue.text = c.percent_change_1h + "%"
            binding.tv24hValue.text = c.percent_change_24h + "%"
            binding.tv7dValue.text = c.percent_change_7d + "%"

            Picasso.with(context)
                .load(
                    StringBuilder(Constants.imageUrl)
                        .append(c.symbol.lowercase(Locale.getDefault()))
                        .append(".png")
                        .toString()
                )
                .into(binding.imgCoin)

            binding.tv1hValue.setTextColor(
                Color.parseColor(
                    when {
                        c.percent_change_1h.contains("-") -> "#ff0000"
                        else -> "#32CD32"
                    }
                )
            )

            binding.tv24hValue.setTextColor(
                Color.parseColor(
                    when {
                        c.percent_change_24h.contains("-") -> "#ff0000"
                        else -> "#32CD32"
                    }
                )
            )

            binding.tv7dValue.setTextColor(
                Color.parseColor(
                    when {
                        c.percent_change_7d.contains("-") -> "#ff0000"
                        else -> "#32CD32"
                    }
                )
            )

        }
    }

    override fun getItemCount(): Int {
        return listCoins.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCryptoBinding.bind(view)

        fun setListener(coin: Coin) {
            binding.root.setOnClickListener {
                listener.onClick(coin)
            }
        }

    }
}

