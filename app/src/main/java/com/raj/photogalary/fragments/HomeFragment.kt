package com.raj.photogalary.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.raj.photogalary.*
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    lateinit var photoList:ArrayList<PhotoSource>
    private var page = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photoList = arrayListOf<PhotoSource>()
        recyclerView.layoutManager = GridLayoutManager(context,2)
        recyclerView.setHasFixedSize(true)

        getPhotos(page)
        fragmentContainer.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener {
                v, scrollX, scrollY, oldScrollX, oldScrollY ->
            if (scrollY == v.getChildAt(0).measuredHeight -v.measuredHeight){
                page++
                getPhotos(page)

            }

        })

    }
    private fun getPhotos(page_no:Int) {
//        Toast.makeText(context,"$page_no", Toast.LENGTH_LONG).show()
        RetrofitInstance.api.getPhotos(page_no,100).enqueue(object : Callback<PhotoResponse> {
            override fun onResponse(call: Call<PhotoResponse>, response: Response<PhotoResponse>) {
//                Toast.makeText(context,"Successfull Call", Toast.LENGTH_LONG).show()
                val photos = response.body()
                for (data in photos!!.hits) {
                    val photo = PhotoSource(data.previewURL,data.largeImageURL,data.fullHDURL)
                    photoList.add(photo)
                }
                recyclerView.adapter = context?.let { PhotoAdapter(it,photoList) }
            }

            override fun onFailure(call: Call<PhotoResponse>, t: Throwable) {
                Toast.makeText(context!!.applicationContext,"Error in Fetching Data", Toast.LENGTH_LONG).show()
            }
        })

    }
}