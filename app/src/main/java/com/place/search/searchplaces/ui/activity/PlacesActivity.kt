package com.place.search.searchplaces.ui.activity

import android.os.Bundle
import com.place.search.searchplaces.R
import com.place.search.searchplaces.ui.base.BaseActivity
import com.place.search.searchplaces.ui.viewmodel.PlacesViewModel

class PlacesActivity : BaseActivity() {

    override val viewModelClass = PlacesViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
