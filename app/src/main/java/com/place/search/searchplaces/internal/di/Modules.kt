package com.place.search.searchplaces.internal.di

import com.place.search.searchplaces.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector fun mainActivity(): MainActivity
}
