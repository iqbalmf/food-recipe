package net.iqbalfauzan.foodrecipe.common.di

import android.app.Application
import net.iqbalfauzan.foodrecipe.common.ssl.TLCSSLSocketFactory
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.iqbalfauzan.foodrecipe.BuildConfig
import net.iqbalfauzan.foodrecipe.common.network.ConnectivityInterceptor
import net.iqbalfauzan.foodrecipe.common.network.NetworkUtil
import net.iqbalfauzan.kit.constant.TagInjectConstant
import okhttp3.Interceptor
import javax.inject.Named
import javax.inject.Singleton
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager

/**
 * Created by Iqbalmf on 2019-07-02
 */
@Module
class ApplicationModule {

    @Provides
    @Singleton
    @Named(TagInjectConstant.APP_INIT_URL_FOODRECIPE)
    fun provideAppInitBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideNetworkUtil(app: Application): NetworkUtil {
        return NetworkUtil(app.applicationContext)
    }

    @Provides
    @Named(TagInjectConstant.SCHEDULER_EXECUTION)
    fun provideExecutionScheduler() = Schedulers.io()

    @Provides
    @Named(TagInjectConstant.SCHEDULER_POST_EXECUTION)
    fun providePostExecutionScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Singleton
    @Named(TagInjectConstant.CONNECTIVITY_INTERCEPTOR)
    fun provideConnectivityInterceptor(networkUtil: NetworkUtil)
            : Interceptor {
        return ConnectivityInterceptor(networkUtil, "Silakan cek koneksi internat Anda.", "Terjadi kesalahan.")
    }

    @Provides
    @Singleton
    @Named(TagInjectConstant.SSL_FACTORY_FOODRECIPE)
    fun provideSSLFactoryKaspro(): SSLSocketFactory {
        return TLCSSLSocketFactory()
    }

    @Provides
    @Singleton
    @Named(TagInjectConstant.SSL_TRUST_MANAGER)
    fun provideSSLTrustManager(): X509TrustManager {
        return TLCSSLSocketFactory().systemDefaultTrustManager()
    }
}