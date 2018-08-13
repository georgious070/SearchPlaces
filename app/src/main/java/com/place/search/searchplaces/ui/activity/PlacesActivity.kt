package com.place.search.searchplaces.ui.activity

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.os.PersistableBundle
import com.place.search.searchplaces.R
import com.place.search.searchplaces.databinding.ActivityPlacesBinding
import com.place.search.searchplaces.ui.base.BaseActivity
import com.place.search.searchplaces.ui.viewmodel.PlacesViewModel
import kotlinx.android.synthetic.main.activity_places.*

class PlacesActivity : BaseActivity<ActivityPlacesBinding, PlacesViewModel>() {

    override val layoutId = R.layout.activity_places
    override val viewModelClass = PlacesViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val adapter = PlacesAdapter().apply { recyclerView.adapter = this }
        viewModel.liveData.observe(this,
                Observer { adapter.updateAdapter(it ?: listOf()) })
    }
}
