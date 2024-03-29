package net.iqbalfauzan.foodrecipe.common.network

import net.iqbalfauzan.kit.constant.ApiConstant
import net.iqbalfauzan.network.custom.IoException
import okhttp3.Interceptor
import okhttp3.Response


class ConnectivityInterceptor(private val networkUtil: NetworkUtil,
                              private val noConnectionMessage: String,
                              private val genericError: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        if (!networkUtil.isOnline()) {
            throw IoException(noConnectionMessage, ApiConstant.HTTP_BAD_REQUEST)
        } else {
            val originResponse: Response = chain!!.proceed(chain.request())
            when (originResponse.code()) {
                ApiConstant.HTTP_TIME_OUT -> throw IoException(genericError, originResponse.code())
                else -> return originResponse
            }
        }
    }
}
