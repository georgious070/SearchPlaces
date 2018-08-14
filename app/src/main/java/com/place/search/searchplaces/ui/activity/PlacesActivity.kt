package com.place.search.searchplaces.ui.activity

import android.arch.lifecycle.Observer
import android.os.Bundle
import com.place.search.searchplaces.R
import com.place.search.searchplaces.databinding.ActivityPlacesBinding
import com.place.search.searchplaces.ui.base.BaseActivity
import com.place.search.searchplaces.ui.models.VenuesParcelable
import com.place.search.searchplaces.ui.viewmodel.PlacesViewModel
import kotlinx.android.synthetic.main.activity_places.*

class PlacesActivity : BaseActivity<ActivityPlacesBinding, PlacesViewModel>() {

    override val layoutId = R.layout.activity_places
    override val viewModelClass = PlacesViewModel::class.java

    var adapter = PlacesAdapter { position, venues -> onVenueClick(position, venues) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView.adapter = adapter
        viewModel.liveData.observe(this,
                Observer { adapter.updateAdapter(it ?: listOf()) })
    }

    private fun onVenueClick(position: Int, venues: List<VenuesParcelable>) {
        startActivity(MapActivity.getIntent(this, position, venues as ArrayList<VenuesParcelable>))
    }
}
