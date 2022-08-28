package com.raj.photogalary

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhotoAdapter(private val context:Context, private val photo_list:ArrayList<PhotoSource>): RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_views,parent,false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentImage = photo_list[position]

        Glide.with(context).load(currentImage.largeImageURL).into(holder.imageView)
        holder.imageView.setOnClickListener {

            val intent = Intent(context,FullImageView::class.java)
            intent.putExtra("image",currentImage.largeImageURL)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return photo_list.size
    }
}

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val imageView:ImageView = itemView.findViewById(R.id.image_view)
}