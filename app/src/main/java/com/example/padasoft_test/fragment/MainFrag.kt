package com.example.padasoft_test.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.padasoft_test.EventObserver
import com.example.padasoft_test.activity.ListActivity
import com.example.padasoft_test.databinding.FragMainBinding
import com.example.padasoft_test.getViewModelFactory
import com.example.padasoft_test.viewmodels.UserViewModel

class MainFrag : Fragment() {
    private val userViewModel by viewModels<UserViewModel> { getViewModelFactory() }
    private lateinit var viewDataBinding: FragMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragMainBinding.inflate(inflater, container, false).apply {
            userviewmodel = userViewModel
        }
        return viewDataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        setupEvent()
    }


    private fun setupEvent() {
        userViewModel.loginCompleteEvent.observe(viewLifecycleOwner, EventObserver {
            activity?.startActivity(Intent(requireContext(), ListActivity::class.java))
        })

        userViewModel.loginFailEvent.observe(viewLifecycleOwner, EventObserver {
            activity?.startActivity(Intent(requireContext(), ListActivity::class.java))
        })
    }


}