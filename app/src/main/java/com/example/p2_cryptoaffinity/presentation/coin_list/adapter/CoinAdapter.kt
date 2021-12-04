package com.example.p2_cryptoaffinity.presentation.coin_list.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.p2_cryptoaffinity.R
import com.example.p2_cryptoaffinity.common.Constants
import com.example.p2_cryptoaffinity.databinding.ItemCryptoBinding
import com.example.p2_cryptoaffinity.domain.model.Coin
import com.squareup.picasso.Picasso
import java.util.*

class CoinAdapter : RecyclerView.Adapter<CoinAdapter.ViewHolder>() {

    private var coinsList: List<Coin> = Collections.emptyList()

    private var listener: OnClickListener? = null
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_crypto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val coin = coinsList[position]

        with(holder) {
            setListener(coin)
            Picasso.with(this@CoinAdapter.context)
                .load(
                    StringBuilder(Constants.imageUrl)
                        .append(coin.symbol.lowercase(Locale.getDefault()))
                        .append(".png")
                        .toString()
                )
                .into(binding.imgCoin)

            binding.tvSymbol.text = coin.symbol
            binding.tvNameCoin.text = coin.name
            binding.tv1hValue.text = coin.percent_change_1h.plus(" %")
            binding.tv24hValue.text = coin.percent_change_24h.plus(" %")
            binding.tv7dValue.text = coin.percent_change_7d.plus(" %")

            binding.tv1hValue.setTextColor(
                Color.parseColor(when {
                coin.percent_change_1h.contains("-") -> "#ff0000"
                else -> "#32CD32"
            }))

            binding.tv24hValue.setTextColor(Color.parseColor(when {
                coin.percent_change_24h.contains("-") -> "#ff0000"
                else -> "#32CD32"
            }))

            binding.tv7dValue.setTextColor(Color.parseColor(when {
                coin.percent_change_7d.contains("-") -> "#ff0000"
                else -> "#32CD32"
            }))

        }

    }

    override fun getItemCount(): Int {
        return coinsList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = ItemCryptoBinding.bind(view)

        fun setListener(coin: Coin) {
            binding.root.setOnClickListener {
                listener!!.onItemClick(coin)
            }
        }

    }

    fun getItem(id: Int): Coin {
        return coinsList[id]
    }

    fun updateData(cryptoCoins: List<Coin>) {
        this.coinsList = cryptoCoins
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onItemClick(coin: Coin)
    }
}




