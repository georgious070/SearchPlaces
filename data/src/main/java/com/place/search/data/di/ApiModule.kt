package com.place.search.data.di

import com.place.search.data.Const
import com.place.search.data.GeocodingApi
import com.place.search.data.VenuesApi
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single { provideOkHttpClient() }
    single("venues") { provideRetrofitBuilderVenues(get()) }
    single { provideVenuesApi(get("venues")) }
    single("geocoding") { provideRetrofitBuilderGeocoding(get()) }
    single { provideGeocodingApi(get("geocoding")) }
}

fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
                .build()

fun provideRetrofitBuilderVenues(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Const.BASE_URL_VANUES)
                .build()

fun provideVenuesApi(retrofit: Retrofit): VenuesApi =
        retrofit.create(VenuesApi::class.java)

fun provideRetrofitBuilderGeocoding(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Const.BASE_URL_GEOCODING)
                .build()

fun provideGeocodingApi(retrofit: Retrofit): GeocodingApi =
        retrofit.create(GeocodingApi::class.java)