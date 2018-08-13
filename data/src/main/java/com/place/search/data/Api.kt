package com.place.search.data

import com.place.search.data.models.GeocodingResponse
import com.place.search.data.models.PlacesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {

    @GET("json")
    fun getCoordinates(@Query("address") address: String): Single<GeocodingResponse>
}

interface VenuesApi {

    companion object {
        const val API_KEY = "AIzaSyCXrLavCYiR8qJhi6YmHhu2nv3f73DqadI"
    }

    @GET("json")
    fun getListOfNearbyVenues(
            @Query("location") locationCoordinates: String,
            @Query("radius") radius: Int = 500,
            @Query("sensor") sensor: Boolean = false,
            @Query("key") key: String = API_KEY
    ): Single<PlacesResponse>
}
