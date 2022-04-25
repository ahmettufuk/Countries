package com.ahmettufuk.countrieskt.util

import android.content.Context

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.ahmettufuk.countrieskt.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

//Extension
/*
fun String.myExtension (myParameter: String) {
    println(myParameter)

}


 */

fun ImageView.downloadFromUrl (Url : String , progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(Url)
        .into(this)

}

fun placeholdeProgressBar (context : Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}

   @BindingAdapter("android:downloadImage")
    fun downloadImage(view: ImageView , url: String) {
        view.downloadFromUrl(url, placeholdeProgressBar(view.context))
    }
