package net.iqbalfauzan.network.custom

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject


class KasproInterceptor
@Inject constructor() : Interceptor {

    override fun intercept(chain: okhttp3.Interceptor.Chain): Response {
        val originRequest: Request = getRequestHeader(chain)
        return chain.proceed(originRequest)
    }

    private fun getRequestHeader(chain: Interceptor.Chain): Request {

        return chain.request()
                .newBuilder()
                .build()
    }
}
