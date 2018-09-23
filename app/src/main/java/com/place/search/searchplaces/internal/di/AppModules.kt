package com.place.search.searchplaces.internal.di

import com.place.search.core.GetCoordinatesUseCase
import com.place.search.core.NetworkRepo
import com.place.search.data.repository.NetworkRepositoryImplementation
import com.place.search.searchplaces.ui.base.BaseViewModel
import com.place.search.searchplaces.ui.base.BaseViewModel.SchedulerType
import com.place.search.searchplaces.ui.viewmodel.PlacesViewModel
import io.reactivex.Scheduler
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { PlacesViewModel(get(), get()) }
}

val schedulersModule = module {
    single { schedulers() }
}

val implModule = module {
    single<NetworkRepo> { NetworkRepositoryImplementation(get(), get()) }
}

val useCaseModule = module {
    factory { GetCoordinatesUseCase(get()) }
}

fun schedulers(): Map<BaseViewModel.SchedulerType, @JvmSuppressWildcards Scheduler> =
        mapOf(
                SchedulerType.WORK to SchedulerType.WORK.instantiateScheduler(),
                SchedulerType.MAIN to SchedulerType.MAIN.instantiateScheduler()
        )
