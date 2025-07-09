package com.example.travelapp

import Attractions
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.travelapp.databinding.FragmentAttractionDetailsBinding
import com.squareup.picasso.Picasso


class AttractionDetailsFragment : BaseFragment() {
    private var _binding : FragmentAttractionDetailsBinding? = null
    private val binding get() = _binding!!
    private val safeArgs : AttractionDetailsFragmentArgs by navArgs()
    private val attraction : Attractions by lazy {
        attractions.find { it.id == safeArgs.attractionId }!!
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAttractionDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleTextView.text = attraction.title
        Picasso.get().load(attraction.image_urls).into(binding.imageHeaderView)
        binding.monthsToVisitTV.text = attraction.months_to_visit
        binding.numberOfFactsTextView.text = "${attraction.facts.size} facts"
        binding.descriptionTV.text = attraction.description
        binding.numberOfFactsTextView.setOnClickListener {

        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }