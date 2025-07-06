package com.example.travelapp

import Attractions
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainActivity : AppCompatActivity() {
    val attractionList : List<Attractions> by lazy {
        parseAttractions()
    }
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

   private fun parseAttractions(): List<Attractions>{
      val textFromFile = resources.openRawResource(R.raw.croatia).bufferedReader().use { it.readText() }
       val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
       val adapter : JsonAdapter<AttractionResponse> = moshi.adapter(AttractionResponse::class.java)
       return adapter.fromJson(textFromFile)!!.attraction
    }
}