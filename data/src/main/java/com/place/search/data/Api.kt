package com.place.search.data

import com.place.search.data.models.Data
import com.place.search.data.models.Result
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {


    @GET("json")
    fun getCoordinates(@Query("address") address: String): Single<Data>
}

interface VenuesApi {

}
