package com.example.padasoft_test.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.padasoft_test.data.news.GetNewsHttp

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<GetNewsHttp.NewsHttp>) {
    if(items!=null)
        (listView.adapter as NewsAdapter).submitList(items)
}

