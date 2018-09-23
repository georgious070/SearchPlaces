package com.place.search.core

import com.place.search.core.models.Venues
import io.reactivex.Single
import javax.inject.Inject

class GetCoordinatesUseCase @Inject constructor(private val networkRepo: NetworkRepo) {

    fun getCurrentLocation(cityName: String): Single<List<Venues>> =
            networkRepo.getCoordinates(cityName)
                    .flatMap {
                        networkRepo.getVenues(it.lat, it.lng)
                    }
}