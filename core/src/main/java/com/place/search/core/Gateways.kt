package com.place.search.core

import com.place.search.core.models.PlaceCoordinates
import io.reactivex.Single

interface NetworkRepo {

    fun getCoordinates(cityName: String): Single<PlaceCoordinates>
}