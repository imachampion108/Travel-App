package com.example.travelapp

import Attractions
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travelapp.arch.AttractionViewModel

abstract class BaseFragment() : Fragment(){
    protected val navController by lazy {
        (activity as MainActivity).navController
    }
    protected val attractionViewModel : AttractionViewModel
        get() = (activity as MainActivity).viewModel
}