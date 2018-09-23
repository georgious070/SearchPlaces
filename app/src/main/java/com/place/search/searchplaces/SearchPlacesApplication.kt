package com.place.search.searchplaces

import android.app.Application
import com.place.search.data.di.apiModule
import com.place.search.searchplaces.internal.di.implModule
import com.place.search.searchplaces.internal.di.schedulersModule
import com.place.search.searchplaces.internal.di.useCaseModule
import com.place.search.searchplaces.internal.di.viewModelModule
import org.koin.android.ext.android.startKoin

class SearchPlacesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(viewModelModule, schedulersModule, implModule, apiModule, useCaseModule))
    }
}