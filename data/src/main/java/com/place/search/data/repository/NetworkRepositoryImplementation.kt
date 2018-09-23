package com.place.search.data.repository

import com.place.search.core.NetworkRepo
import com.place.search.core.models.PlaceCoordinates
import com.place.search.core.models.Venues
import com.place.search.data.GeocodingApi
import com.place.search.data.VenuesApi
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkRepositoryImplementation @Inject constructor(
        private val geoApi: GeocodingApi,
        private val venuesApi: VenuesApi
) : NetworkRepo {

    override fun getCoordinates(cityName: String): Single<PlaceCoordinates> =
            geoApi.getCoordinates(cityName)
                    .map {
                        PlaceCoordinates(it.results[0].geometry.location.lat, it.results[0].geometry.location.lng)
                    }

    override fun getVenues(lat: Double, lng: Double): Single<List<Venues>> =
            venuesApi.getListOfNearbyVenues("$lat,$lng")
                    .map { placesData ->
                        placesData.venues
                                .map {
                                    Venues(it.name, it.icon, PlaceCoordinates(it.geometry.location.lat, it.geometry.location.lng))
                                }
                    }
}