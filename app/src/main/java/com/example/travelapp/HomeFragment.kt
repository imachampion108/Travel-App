package com.example.travelapp

import Attractions
import android.icu.lang.UCharacter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.travelapp.databinding.FragmentHomeBinding


class HomeFragment() : BaseFragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeAdapter = HomeFragmentAdapter {
        }
        binding.recyclerview.adapter = homeAdapter
        binding.recyclerview.addItemDecoration(DividerItemDecoration(requireActivity(),RecyclerView.VERTICAL))
        homeAdapter.setData(attractions)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}