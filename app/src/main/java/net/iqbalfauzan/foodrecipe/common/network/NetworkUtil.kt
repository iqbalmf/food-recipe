package net.iqbalfauzan.foodrecipe.common.network

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Iqbalmf on 2019-07-02
 */
class NetworkUtil(private val context: Context) {

    fun isOnline(): Boolean {
        val netInfo = (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }
}