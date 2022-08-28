package com.raj.photogalary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.raj.photogalary.PhotoSource
import com.raj.photogalary.R
import com.raj.photogalary.adapters.CategoryAdapter
import com.raj.photogalary.models.CategoryModel
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_home.*

class CategoryFragment : Fragment() {

    lateinit var categoryList:ArrayList<CategoryModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryList = arrayListOf<CategoryModel>()
        categoryList.add(CategoryModel(R.drawable.black_car,"Super Cars"))
        categoryList.add(CategoryModel(R.drawable.bikes,"Bikes"))
        categoryList.add(CategoryModel(R.drawable.flowers,"Flowers"))
        categoryList.add(CategoryModel(R.drawable.architecture,"Architecture"))
        categoryList.add(CategoryModel(R.drawable.birds,"Birds"))
//        categoryList.add(CategoryModel(R.drawable.a,"Abstract"))
        categoryList.add(CategoryModel(R.drawable.nature,"Nature"))
        categoryList.add(CategoryModel(R.drawable.black_wallpaper,"Black Wallpaper"))
        categoryList.add(CategoryModel(R.drawable.photography,"Photography"))
        categoryList.add(CategoryModel(R.drawable.space,"Space"))
        categoryList.add(CategoryModel(R.drawable.girls,"Girls"))
        categoryList.add(CategoryModel(R.drawable.quotes,"Quotes"))
        categoryList.add(CategoryModel(R.drawable.animals,"Animals"))


        category_recyclerview.adapter = context?.let { CategoryAdapter(it,categoryList) }
        category_recyclerview.layoutManager = GridLayoutManager(context,2)
        category_recyclerview.setHasFixedSize(true)

    }

}