package com.example.travelapp

import Attractions
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.navArgs
import com.example.travelapp.databinding.FragmentAttractionDetailsBinding
import com.squareup.picasso.Picasso


class AttractionDetailsFragment : BaseFragment() {
    private var _binding : FragmentAttractionDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentAttractionDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attractionViewModel.attractionSelectedLiveData.observe(viewLifecycleOwner) { attraction ->
            binding.titleTextView.text = attraction.title
            Picasso.get().load(attraction.image_urls).into(binding.imageHeaderView)
            binding.monthsToVisitTV.text = attraction.months_to_visit
            binding.numberOfFactsTextView.text = "${attraction.facts.size} facts"
            binding.descriptionTV.text = attraction.description
            binding.numberOfFactsTextView.setOnClickListener {
                var stringBuilder = StringBuilder("")
                attraction.facts.forEach {
                    stringBuilder.append("\u2022 $it")
                    stringBuilder.append("\n\n")
                }
                val message = stringBuilder.toString()
                    .substring(0, stringBuilder.toString().lastIndexOf("\n\n"))
                AlertDialog.Builder(requireContext())
                    .setTitle("${attraction.title} Facts")
                    .setMessage(message)
                    .setPositiveButton("OK") { dialog, which -> }
                    .show()


            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
          inflater.inflate(R.menu.menu_attraction_details,menu)    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menuItemLocation -> {
                val attraction = attractionViewModel.attractionSelectedLiveData.value ?: return true
                attractionViewModel.locationLiveData.postValue(attraction)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }