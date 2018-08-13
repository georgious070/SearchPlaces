package com.place.search.searchplaces.internal.di

import android.arch.lifecycle.ViewModel
import com.place.search.searchplaces.Const
import com.place.search.searchplaces.ui.base.BaseViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class SchedulerTypeKey(val value: BaseViewModel.SchedulerType)

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)