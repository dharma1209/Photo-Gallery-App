package com.raj.photogalary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_search_result.*
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchResultActivity : AppCompatActivity() {
    lateinit var searchPhotoList:ArrayList<PhotoSource>
    lateinit var query:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        query = intent.getStringExtra("query").toString()
        supportActionBar?.title = query
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        searchPhotoList = arrayListOf<PhotoSource>()
        categoryRecyclerView.layoutManager = GridLayoutManager(this,2)
        categoryRecyclerView.setHasFixedSize(true)

        searchPhotos()
    }

    private fun searchPhotos() {
        RetrofitInstance.api.searchPhotos(198,query).enqueue(object : Callback<PhotoResponse> {
            override fun onResponse(call: Call<PhotoResponse>, response: Response<PhotoResponse>) {
//                Toast.makeText(context,"Successfull Call", Toast.LENGTH_LONG).show()
                val photos = response.body()
                searchPhotoList.clear()
                for (data in photos!!.hits) {
                    val photo = PhotoSource(data.previewURL,data.largeImageURL,data.fullHDURL)
                    searchPhotoList.add(photo)
                }
                categoryRecyclerView.adapter = PhotoAdapter(this@SearchResultActivity,searchPhotoList)
            }

            override fun onFailure(call: Call<PhotoResponse>, t: Throwable) {
                Toast.makeText(applicationContext,"Error in Fetching Data", Toast.LENGTH_LONG).show()
            }
        })

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}