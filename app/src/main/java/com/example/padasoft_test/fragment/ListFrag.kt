package com.example.padasoft_test.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.padasoft_test.EventObserver
import com.example.padasoft_test.activity.DetailActivity
import com.example.padasoft_test.adapter.NewsAdapter
import com.example.padasoft_test.databinding.FragListBinding
import com.example.padasoft_test.getViewModelFactory
import com.example.padasoft_test.viewmodels.NewsViewModel

class ListFrag : Fragment() {
    private val newsViewModel by viewModels<NewsViewModel> { getViewModelFactory() }
    private lateinit var viewDataBinding: FragListBinding

    private lateinit var listAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragListBinding.inflate(inflater, container, false).apply {
            newsviewmodel = newsViewModel
            lifecycleOwner = this@ListFrag
        }
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        val viewModel = viewDataBinding.newsviewmodel
        if (viewModel != null) {
            listAdapter = NewsAdapter(viewModel)
            viewDataBinding.rvNewslist.adapter = listAdapter
        } else {
            Log.e("setUpAdapter","view model is null")
        }
        newsViewModel.getAllNews()
        setupEvent()
    }

    private fun setupEvent() {
        newsViewModel.chooseEvent.observe(viewLifecycleOwner, EventObserver {
            activity?.startActivity(Intent(requireContext(), DetailActivity::class.java))
        })

    }

}