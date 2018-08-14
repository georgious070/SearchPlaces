package com.place.search.searchplaces.ui.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import com.place.search.core.GetCoordinatesUseCase
import com.place.search.searchplaces.ui.base.BaseViewModel
import com.place.search.searchplaces.ui.models.PlaceCoordinatesParcelable
import com.place.search.searchplaces.ui.models.VenuesParcelable
import io.reactivex.Scheduler
import javax.inject.Inject

class PlacesViewModel @Inject constructor(
        private val schedulers: Map<SchedulerType, @JvmSuppressWildcards Scheduler>,
        private val getCoordinates: GetCoordinatesUseCase
) : BaseViewModel() {

    val cityName = ObservableField<String>("")
    val liveData = MutableLiveData<List<VenuesParcelable>>()
    val emptyMessageVisibility = ObservableBoolean()

    fun executeCoordinates() {
        getCoordinates.getCurrentLocation(cityName.get().toString())
                .subscribeOn(schedulers[SchedulerType.WORK])
                .observeOn(schedulers[SchedulerType.MAIN])
                .subscribe(
                        { venues ->
                            emptyMessageVisibility.set(venues.isEmpty())
                            val venuesParcelable = venues.map { VenuesParcelable(it.name, it.photoUrl, PlaceCoordinatesParcelable(it.coordinates.lat, it.coordinates.lng)) }
                            liveData.postValue(venuesParcelable)
                        }, { emptyMessageVisibility.set(true) }
                ).let { disposables.add(it) }
    }
}
