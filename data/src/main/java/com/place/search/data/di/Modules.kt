package com.place.search.data.di

import com.place.search.data.Const
import com.place.search.data.GeocodingApi
import com.place.search.data.VenuesApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    @Named(Const.NAME_GEOCODING)
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
    fun provideRetrofitBuilderVenues(client: OkHttpClient): Retrofit =
            Retrofit.Builder()
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(Const.BASE_URL_VANUES)
                    .build()

    @Provides
    fun provideVenuesApi(@Named(Const.NAME_VENUES) retrofit: Retrofit): VenuesApi =
            retrofit.create(VenuesApi::class.java)
}