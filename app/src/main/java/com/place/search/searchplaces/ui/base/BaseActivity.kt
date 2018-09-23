package com.place.search.searchplaces.ui.base

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.place.search.searchplaces.BR
import javax.inject.Inject

abstract class BaseActivity<VB : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {

    abstract val layoutId: Int
    abstract val viewModel: VM

    @Inject lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.setVariable(BR.viewModel, viewModel)
    }
}