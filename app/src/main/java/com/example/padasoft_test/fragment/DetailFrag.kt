package com.example.padasoft_test.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.padasoft_test.EventObserver
import com.example.padasoft_test.activity.DetailActivity
import com.example.padasoft_test.activity.ListActivity
import com.example.padasoft_test.databinding.FragDetailBinding

import com.example.padasoft_test.databinding.FragListBinding
import com.example.padasoft_test.getViewModelFactory
import com.example.padasoft_test.viewmodels.NewsViewModel

class DetailFrag : Fragment() {
    private val newsViewModel by viewModels<NewsViewModel> { getViewModelFactory() }
    private lateinit var viewDataBinding: FragDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragDetailBinding.inflate(inflater, container, false).apply {
            newsviewmodel = newsViewModel
            lifecycleOwner = this@DetailFrag
        }
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
    }
}