package com.example.travelapp

import Attractions
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment() : Fragment(){
    protected val navController by lazy {
        (activity as MainActivity).navController
    }
    protected val attractions : List<Attractions>
        get() = (activity as MainActivity).attractionList
}