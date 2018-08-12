package com.place.search.searchplaces.internal.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.place.search.searchplaces.ViewModelFactory
import com.place.search.searchplaces.ui.activity.PlacesActivity
import com.place.search.searchplaces.ui.viewmodel.PlacesViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface ActivityModule {

    @ContributesAndroidInjector fun mainActivity(): PlacesActivity
}

@Module
interface ViewModelModule {

    @Binds
    fun viewmodelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PlacesViewModel::class)
    fun providePlacesViewModel(placesViewModel: PlacesViewModel): ViewModel
}