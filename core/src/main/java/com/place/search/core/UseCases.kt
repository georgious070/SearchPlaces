package com.place.search.core

import com.place.search.core.models.Venues
import io.reactivex.Single

class GetCoordinatesUseCase constructor(private val networkRepo: NetworkRepo) {

    fun getCurrentLocation(cityName: String): Single<List<Venues>> =
            networkRepo.getCoordinates(cityName)
                    .flatMap {
                        networkRepo.getVenues(it.lat, it.lng)
                    }
}