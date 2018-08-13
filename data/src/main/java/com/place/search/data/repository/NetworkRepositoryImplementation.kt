package com.place.search.data.repository

import com.place.search.core.NetworkRepo
import com.place.search.core.models.PlaceCoordinates
import com.place.search.data.GeocodingApi
import com.place.search.data.VenuesApi
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkRepositoryImplementation @Inject constructor(
        val geoApi: GeocodingApi,
        val venuesApi: VenuesApi

) : NetworkRepo {

    override fun getCoordinates(cityName: String): Single<PlaceCoordinates> =
            geoApi.getCoordinates(cityName)
                    .map { PlaceCoordinates(it.results[0].geometry.location.lat.toLong(), it.results[0].geometry.location.lat.toLong()) }
}