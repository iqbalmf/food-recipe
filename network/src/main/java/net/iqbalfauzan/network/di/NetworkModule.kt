package net.iqbalfauzan.network.di

import dagger.Module
import dagger.Provides
import net.iqbalfauzan.data.repository.FoodService
import net.iqbalfauzan.kit.constant.TagInjectConstant
import net.iqbalfauzan.network.rest.FoodServiceImpl
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.X509TrustManager

/**
 * Created by Iqbalmf on 2019-07-21
 */
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideFoodService(
        @Named(TagInjectConstant.RETROFIT_FOODRECIPE) retrofit: Retrofit
    ): FoodService = FoodServiceImpl(retrofit)

    @Provides
    @Singleton
    @Named(TagInjectConstant.RETROFIT_FOODRECIPE)
    fun provideRetrofit(
        @Named(TagInjectConstant.OKHTTP_FOODRECIPE) okHttpClient: OkHttpClient,
        @Named(TagInjectConstant.APP_INIT_URL_FOODRECIPE) baseUrl: String
    )
            : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named(TagInjectConstant.OKHTTP_FOODRECIPE)
    fun provideOkHttpClient(
        certificatePinner: CertificatePinner,
        @Named(TagInjectConstant.SSL_FACTORY_FOODRECIPE) sslSocketFactory: SSLSocketFactory,
        @Named(TagInjectConstant.SSL_TRUST_MANAGER) x509TrustManager: X509TrustManager,
        @Named(TagInjectConstant.CONNECTIVITY_INTERCEPTOR) connectivityInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory, x509TrustManager)
            .certificatePinner(certificatePinner)
            .addInterceptor(connectivityInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideCertificatePinner(): CertificatePinner {
        return CertificatePinner.Builder()
            .build()
    }
}