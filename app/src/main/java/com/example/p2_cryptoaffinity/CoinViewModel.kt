package com.example.p2_cryptoaffinity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.p2_cryptoaffinity.interfaces.APIInterface
import com.example.p2_cryptoaffinity.retrofit.Coin
import com.example.p2_cryptoaffinity.retrofit.CryptoList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinViewModel : ViewModel(){
    private var apiInterface: APIInterface = APIClient().getClient()!!.create(APIInterface::class.java)

    val listCoins : MutableLiveData<MutableList<Coin>> by lazy {
        MutableLiveData<MutableList<Coin>>()
    }

    init {
        getCoinList()
    }

    private fun getCoinList() {

        val call2: Call<CryptoList?>? = apiInterface.doGetUserList("100")
        call2!!.enqueue(object : Callback<CryptoList?> {

            override fun onResponse(call: Call<CryptoList?>?, response: Response<CryptoList?>) {
                val list: CryptoList = response.body()!!
                    listCoins.value = list.coins as MutableList<Coin>
            }

            override fun onFailure(call: Call<CryptoList?>, t: Throwable) {
                call.cancel()
            }
        })
    }

}