package com.place.search.core

import com.place.search.core.models.PlaceCoordinates
import com.place.search.core.models.Venues
import io.reactivex.Single

interface NetworkRepo {

    fun getCoordinates(cityName: String): Single<PlaceCoordinates>

    fun getVenues(lat: Double, lng: Double): Single<List<Venues>>
}