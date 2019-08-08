package net.iqbalfauzan.network.custom

import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException


class IoException(private val errorMessage: String?,
                  private val code: Int) : IOException(errorMessage) {

    fun fetchErrorMessage():String {
        return errorMessage ?: localizedMessage
    }

    fun code() = code
}
