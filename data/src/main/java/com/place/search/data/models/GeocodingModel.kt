package com.place.search.data.models

import com.google.gson.annotations.SerializedName

data class GeocodingResponse(@SerializedName("results") val results: List<Result>)

data class Result(@SerializedName("geometry") val geometry: Geometry)

data class Geometry(@SerializedName("location") val location: Location)

data class Location(
        @SerializedName("lat") val lat: Double,
        @SerializedName("lng") val lng: Double
)