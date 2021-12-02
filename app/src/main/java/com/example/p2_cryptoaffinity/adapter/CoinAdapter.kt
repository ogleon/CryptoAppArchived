package com.example.p2_cryptoaffinity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.p2_cryptoaffinity.R
import com.example.p2_cryptoaffinity.databinding.ItemCryptoBinding
import com.example.p2_cryptoaffinity.retrofit.Coin
import com.squareup.picasso.Picasso
import java.util.*

class CryptoListAdapter(private val coins: List<Coin>) :
    RecyclerView.Adapter<CryptoListAdapter.ViewHolder>() {
    private var listener: OnClickListener? = null
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_crypto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val c = coins[position]

        with(holder) {
            setListener(c)
            Picasso.with(this@CryptoListAdapter.context)
                .load(
                    StringBuilder(Constants.imageUrl)
                        .append(c.symbol!!.lowercase(Locale.getDefault()))
                        .append(".png")
                        .toString()
                )
                .into(binding.imgCoin)

            binding.tvSymbol.text = c.symbol
            binding.tvNameCoin.text = c.name
            binding.tv1hValue.text = c.quote!!.uSD!!.percentChange1h.toString().plus(" %")
            binding.tv24hValue.text = c.quote!!.uSD!!.percentChange24h.toString().plus(" %")
            binding.tv7dValue.text = c.quote!!.uSD!!.percentChange7d.toString().plus(" %")
        }

    }

    override fun getItemCount(): Int {
        return coins.size
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
        return coins[id]
    }

    interface OnClickListener {
        fun onItemClick(coin: Coin)
    }
}




