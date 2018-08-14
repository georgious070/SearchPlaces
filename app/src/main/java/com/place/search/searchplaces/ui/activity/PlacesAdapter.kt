package com.place.search.searchplaces.ui.activity

import android.databinding.DataBindingUtil
import android.databinding.ObservableField
import android.databinding.ViewDataBinding
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.place.search.searchplaces.BR
import com.place.search.searchplaces.R
import com.place.search.searchplaces.ui.models.VenuesParcelable

class PlacesAdapter(val clickVenue: (Int, List<VenuesParcelable>) -> Unit) : RecyclerView.Adapter<PlacesAdapter.PlaceViewHolder>() {

    private var places = listOf<VenuesParcelable>()


    fun updateAdapter(venues: List<VenuesParcelable>) {
        val diffResult = DiffUtil.calculateDiff(BaseDiffUtilCallback(venues, places))
        places = venues
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_venue,
                parent,
                false)
        return PlaceViewHolder(binding.root).also { binding.setVariable(BR.viewModel, it) }
    }

    override fun getItemCount(): Int = places.size

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) =
            holder.item.set(places[position])

    inner class PlaceViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val item = ObservableField<VenuesParcelable>()

        fun handleVenueClick() {
            clickVenue(adapterPosition, places)
        }
    }
}

class BaseDiffUtilCallback(
        private val newList: List<VenuesParcelable>, private val oldList: List<VenuesParcelable>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].name == newList[newItemPosition].name

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].name == newList[newItemPosition].name &&
                    oldList[oldItemPosition].coordinates.lat == newList[newItemPosition].coordinates.lat &&
                    oldList[oldItemPosition].coordinates.lng == newList[newItemPosition].coordinates.lng
}