package com.place.search.searchplaces.ui.base

import android.arch.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

open class BaseViewModel : ViewModel() {

    val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

    enum class SchedulerType(private val scheduler: Scheduler) {
        WORK(Schedulers.io()),
        MAIN(AndroidSchedulers.mainThread());

        fun instantiateScheduler(): Scheduler = scheduler
    }
}