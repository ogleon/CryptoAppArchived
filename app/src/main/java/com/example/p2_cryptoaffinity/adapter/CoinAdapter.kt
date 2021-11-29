package com.example.p2_cryptoaffinity.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.p2_cryptoaffinity.R
import com.example.p2_cryptoaffinity.databinding.ItemCryptoBinding
import com.example.p2_cryptoaffinity.models.Coin

class CoinAdapter(
    private val listCoins: MutableList<Coin>,
    private val listener: OnClickListener
) : RecyclerView.Adapter<CoinAdapter.ViewHolder>() {

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
            binding.itemIc.imageAlpha
            binding.itemName.text = c.CoinName
            binding.itemIcPrice
            binding.itemPriceValue.text = c.price.toString()
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

