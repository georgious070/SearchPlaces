package com.place.search.searchplaces.ui.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.place.search.core.GetCoordinatesUseCase
import com.place.search.core.models.Venues
import com.place.search.searchplaces.ui.base.BaseViewModel
import io.reactivex.Scheduler
import javax.inject.Inject

class PlacesViewModel @Inject constructor(
        private val schedulers: Map<SchedulerType, @JvmSuppressWildcards Scheduler>,
        private val getCoordinates: GetCoordinatesUseCase
) : BaseViewModel() {

    val cityName = ObservableField<String>("")
    val liveData = MutableLiveData<List<Venues>>()

    fun executeCoordinates() {
        getCoordinates.getCurrentLocation(cityName.get().toString())
                .subscribeOn(schedulers[SchedulerType.WORK])
                .observeOn(schedulers[SchedulerType.MAIN])
                .subscribe { venues ->
                    liveData.postValue(venues)
                }
                .let { disposables.add(it) }
    }
}