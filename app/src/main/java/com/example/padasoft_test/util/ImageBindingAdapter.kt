package com.example.padasoft_test.util

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view: ImageView, url: String) {
        Glide.with(view.context).load(url).centerCrop().into(view)
    }

    @SuppressLint("SimpleDateFormat")
    @JvmStatic
    @BindingAdapter("android:src")
    fun setText(view: TextView, text: String) {
        try {
            val sdf = SimpleDateFormat("d/MM/yyyy")
            val date = Date(text.toLong() * 1000)
            view.text = sdf.format(date)
        } catch (ex: Exception) {
            view.text = text
        }
    }
}