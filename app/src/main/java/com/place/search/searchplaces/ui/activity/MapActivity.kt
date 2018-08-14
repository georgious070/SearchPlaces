package com.place.search.searchplaces.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.place.search.searchplaces.R
import com.place.search.searchplaces.ui.models.VenuesParcelable
import dagger.android.support.DaggerAppCompatActivity

class MapActivity : DaggerAppCompatActivity(), OnMapReadyCallback {

    companion object {
        const val ARG_CENTRAL_VENUE_POSITION = "CENTRAL_VENUE_POSITION"
        const val ARG_VENUES = "VENUES"

        fun getIntent(context: Context, centralVenuePosition: Int, venues: ArrayList<VenuesParcelable>) =
                Intent(context, MapActivity::class.java)
                        .apply {
                            putExtra(ARG_CENTRAL_VENUE_POSITION, centralVenuePosition)
                            putExtra(ARG_VENUES, venues)
                        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.placesMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val venues = intent.getParcelableArrayListExtra<VenuesParcelable>(ARG_VENUES)
        val centPosition = intent.getIntExtra(ARG_CENTRAL_VENUE_POSITION, 0)
        venues.forEach {
            googleMap.addMarker(MarkerOptions().position(LatLng(it.coordinates.lat, it.coordinates.lng))
                    .title(it.name))
        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(LatLng(venues[centPosition].coordinates.lat, venues[centPosition].coordinates.lng)))
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(20.0f), 2000, null)
    }
}