package com.place.search.data.models

import com.google.gson.annotations.SerializedName

data class PlacesResponse(@SerializedName("results") val venues: List<Venue>)

data class Venue(
        @SerializedName("geometry") val geometry: Geometry,
        @SerializedName("icon") val icon: String,
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("rating") val rating: Int,
        @SerializedName("opening_hours") val opening_hours: OpeningHours
)

data class OpeningHours(@SerializedName("open_now") val open_now: Boolean)