package com.place.search.searchplaces

import android.databinding.BindingAdapter
import android.databinding.BindingConversion
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun ImageView.setImageUri(url: String?) {
    when (url) {
        null -> setImageDrawable(null)
        else -> Glide.with(context)
                .load(url)
                .into(this)
    }
}

@BindingConversion
fun booleanToVisibility(
        visible: Boolean
) = View.VISIBLE.takeIf { visible } ?: View.GONE
