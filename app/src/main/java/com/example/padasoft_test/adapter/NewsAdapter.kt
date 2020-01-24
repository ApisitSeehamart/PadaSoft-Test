package com.example.padasoft_test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.padasoft_test.data.news.GetNewsHttp
import com.example.padasoft_test.databinding.ItemNewsBinding
import com.example.padasoft_test.viewmodels.NewsViewModel

class NewsAdapter (
    private val viewModel : NewsViewModel
):ListAdapter<GetNewsHttp.NewsHttp, NewsAdapter.ViewHolder>(NewsCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(viewModel, item)
    }
    class ViewHolder private constructor(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(viewModel : NewsViewModel, item: GetNewsHttp.NewsHttp) {

            binding.news = item
            binding.newsviewmodel = viewModel
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNewsBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class NewsCallback : DiffUtil.ItemCallback<GetNewsHttp.NewsHttp>(){
    override fun areItemsTheSame(oldItem: GetNewsHttp.NewsHttp, newItem: GetNewsHttp.NewsHttp): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GetNewsHttp.NewsHttp, newItem: GetNewsHttp.NewsHttp): Boolean {
        return oldItem == newItem
    }
}