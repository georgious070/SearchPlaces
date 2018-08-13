package com.place.search.data.di

import com.place.search.data.Const
import com.place.search.data.GeocodingApi
import com.place.search.data.VenuesApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideOkHttpClient(logger: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()

    @Provides
    fun provideLoggingInterceptor() =
            HttpLoggingInterceptor()
                    .apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Named(Const.NAME_GEOCODING)
    @Singleton
    fun provideRetrofitBuilderGeocoding(client: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Const.BASE_URL_GEOCODING)
                    .build()

    @Provides
    fun provideGeocodingApi(@Named(Const.NAME_GEOCODING) retrofit: Retrofit): GeocodingApi =
            retrofit.create(GeocodingApi::class.java)

    @Provides
    @Named(Const.NAME_VENUES)
    @Singleton
    fun provideRetrofitBuilderVenues(): Retrofit =
            Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Const.BASE_URL_VANUES)
                    .build()

    @Provides
    fun provideVenuesApi(@Named(Const.NAME_VENUES) retrofit: Retrofit): VenuesApi =
            retrofit.create(VenuesApi::class.java)
}