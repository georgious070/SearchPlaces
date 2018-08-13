package com.place.search.core

import com.place.search.core.models.PlaceCoordinates
import io.reactivex.Single
import javax.inject.Inject

class GetCoordinatesUseCase @Inject constructor(private val networkRepo: NetworkRepo) {

    fun getCurrentLocation(cityName: String): Single<PlaceCoordinates> =
            networkRepo.getCoordinates(cityName)
}