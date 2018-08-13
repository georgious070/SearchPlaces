package com.place.search.searchplaces.internal.di

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.place.search.core.NetworkRepo
import com.place.search.data.repository.NetworkRepositoryImplementation
import com.place.search.searchplaces.Const
import com.place.search.searchplaces.ViewModelFactory
import com.place.search.searchplaces.ui.activity.PlacesActivity
import com.place.search.searchplaces.ui.base.BaseViewModel
import com.place.search.searchplaces.ui.viewmodel.PlacesViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
interface ActivityModule {

    @ContributesAndroidInjector fun placesActivity(): PlacesActivity
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

@Module
class SchedulersModule {

    @Provides
    @IntoMap
    @SchedulerTypeKey(BaseViewModel.SchedulerType.WORK)
    fun provideWorkScheduler(): Scheduler = Schedulers.io()

    @Provides
    @IntoMap
    @SchedulerTypeKey(BaseViewModel.SchedulerType.MAIN)
    fun provideWorkResultScheduler(): Scheduler = AndroidSchedulers.mainThread()
}

@Module
interface ImplementationsModule {
    @Binds fun context(application: Application): Context
    @Binds fun networkRepo(networkRepo: NetworkRepositoryImplementation): NetworkRepo
}
