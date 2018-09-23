package com.place.search.searchplaces.ui.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class VenuesParcelable(val name: String, val photoUrl: String, val coordinates: PlaceCoordinatesParcelable) : Parcelable

@Parcelize
data class PlaceCoordinatesParcelable(val lat: Double, val lng: Double) : Parcelable