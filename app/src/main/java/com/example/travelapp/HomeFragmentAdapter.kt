package com.example.travelapp

import Attractions
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.travelapp.databinding.ViewHolderAttractionBinding
import com.squareup.picasso.Picasso

class HomeFragmentAdapter( private val onClickedBack: (String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val attraction = ArrayList<Attractions>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  MyViewholder(parent)  }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MyViewholder).onBind(attraction[position], onClickedBack)    }

    override fun getItemCount(): Int {
        return attraction.size    }

    fun setData(attraction : List<Attractions>){
        this.attraction.clear()
        this.attraction.addAll(attraction)
        notifyDataSetChanged()

    }
    inner class MyViewholder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_attraction,parent,false)
    ){
        private val binding = ViewHolderAttractionBinding.bind(itemView)
        fun onBind(attractions: Attractions, onClicked : (String) -> Unit){
            binding.titleTextView.text = attractions.title
            binding.monthsToVisitTV.text = attractions.months_to_visit
            Picasso.get().load(attractions.image_urls).into(binding.imageHeaderView)
               binding.root.setOnClickListener {
                  onClicked
               }
        }
    }
}

