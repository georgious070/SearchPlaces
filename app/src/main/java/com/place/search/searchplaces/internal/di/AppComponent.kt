package com.place.search.searchplaces.internal.di

import com.place.search.searchplaces.SearchPlacesApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            AndroidSupportInjectionModule::class,
            ActivityModule::class,
            ViewModelModule::class
        ]
)
interface AppComponent : AndroidInjector<SearchPlacesApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<SearchPlacesApplication>()
}