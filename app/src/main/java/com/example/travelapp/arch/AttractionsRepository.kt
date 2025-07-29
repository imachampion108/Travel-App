package com.example.travelapp.arch

import Attractions
import android.content.Context
import com.example.travelapp.AttractionResponse
import com.example.travelapp.R
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class AttractionsRepository {
    fun parseAttractions(context: Context): List<Attractions>{
        val textFromFile = context.resources.openRawResource(R.raw.croatia).bufferedReader().use { it.readText() }
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        val adapter : JsonAdapter<AttractionResponse> = moshi.adapter(AttractionResponse::class.java)
        return adapter.fromJson(textFromFile)!!.attractions
    }
}