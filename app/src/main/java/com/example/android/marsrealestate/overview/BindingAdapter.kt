package com.example.android.marsrealestate.overview

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android.marsrealestate.R
import com.example.android.marsrealestate.network.MarsApi
import com.example.android.marsrealestate.network.MarsProperty

@BindingAdapter("imageUrl")
fun ImageView.setImageUri(imgUrl: String?){
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(context).load(imgUri)
            .apply(RequestOptions().placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(this)

    }
}
@BindingAdapter("listData")
fun RecyclerView.setListData(listData: List<MarsProperty>?){
    listData?.let {
        (adapter as PhotoGridAdapter).submitList(listData)
    }
}
@BindingAdapter("marsApiStatus")
fun ImageView.setMarsApiStatus(status: MarsApiStatus){
    when(status){
        MarsApiStatus.LOADING -> {
            visibility = View.VISIBLE
            setImageResource(R.drawable.loading_animation)
        }
        MarsApiStatus.DONE -> {
            visibility = View.GONE
        }
        MarsApiStatus.ERROR -> {
            visibility = View.VISIBLE
            setImageResource(R.drawable.ic_connection_error)
        }
    }
}