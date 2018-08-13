package com.place.search.searchplaces.ui.activity

import com.place.search.searchplaces.R
import com.place.search.searchplaces.databinding.ActivityPlacesBinding
import com.place.search.searchplaces.ui.base.BaseActivity
import com.place.search.searchplaces.ui.viewmodel.PlacesViewModel

class PlacesActivity : BaseActivity<ActivityPlacesBinding, PlacesViewModel>() {

    override val layoutId = R.layout.activity_places
    override val viewModelClass = PlacesViewModel::class.java
}
