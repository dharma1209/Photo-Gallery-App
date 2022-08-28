package com.raj.photogalary.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raj.photogalary.R
import com.raj.photogalary.SearchResultActivity
import com.raj.photogalary.models.CategoryModel

class CategoryAdapter(val context: Context, private val category_list: ArrayList<CategoryModel>): RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_list_items,parent,false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem = category_list[position]
        holder.categoryTitle.text = currentItem.categoryTitle
        Glide.with(context).load(currentItem.categoryImage).into(holder.categoryImage)

        holder.itemView.setOnClickListener {
            val intent = Intent(context,SearchResultActivity::class.java)
            intent.putExtra("query",currentItem.categoryTitle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return category_list.size
    }
}
class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val categoryImage:ImageView = itemView.findViewById(R.id.category_image)
    val categoryTitle:TextView = itemView.findViewById(R.id.category_name)
}