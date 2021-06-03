package com.divesh.myphotos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.divesh.myphotos.databinding.LayoutRowBinding

class GalleryAdapter: RecyclerView.Adapter<GalleryAdapter.PhotoViewHolder>() {

    var dogsList = ArrayList<Dogs>()

    fun setListData(list: ArrayList<Dogs>){
        this.dogsList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = LayoutRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(dogsList[position])
    }

    override fun getItemCount() = dogsList.size

    class PhotoViewHolder(val layoutbinding: LayoutRowBinding):RecyclerView.ViewHolder(layoutbinding.root){

        fun bind(dog: Dogs){
            layoutbinding.apply {
                Glide.with(itemView)
                    .load(dog.url)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(imageView)
            }
        }
    }

}