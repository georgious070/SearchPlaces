package com.place.search.searchplaces

import android.databinding.BindingAdapter
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