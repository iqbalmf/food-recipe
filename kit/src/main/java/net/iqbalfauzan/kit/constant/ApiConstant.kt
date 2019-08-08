package net.iqbalfauzan.kit.constant

/**
 * Created by Iqbalmf on 2019-08-08
 */
class ApiConstant {

    companion object {
        const val TIME_OUT_IN_SECONDS: Long = 60
        const val REQUEST_COUNT_LIMIT = 3

        const val HTTP_RESPONSE_UNAUTHORIZED = 401
        const val HTTP_RESPONSE_FORBIDDEN = 403
        const val HTTP_BAD_REQUEST = 400
        const val HTTP_TIME_OUT = 504

        // Success response codes
        const val HTTP_RESPONSE_OK = 200
        const val HTTP_RESPONSE_CREATED = 201
        const val HTTP_RESPONSE_NO_CONTENT = 204
        const val HTTP_RESPONSE_NOT_MODIFIED = 304
    }
}