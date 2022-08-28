package com.raj.photogalary

import android.app.WallpaperManager
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_full_image_view.*
import java.io.IOException


class FullImageView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image_view)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val hdImage = intent.getStringExtra("image")
        val fullImageView:ImageView = findViewById(R.id.fullImageView)
        Glide.with(this).load(hdImage).into(fullImageView)

        setWallpaper.setOnClickListener {
            setWall()
        }
    }

    private fun setWall() {
        val wallpaperManager = WallpaperManager.getInstance(this)
        val bitmap = (fullImageView.getDrawable() as BitmapDrawable).bitmap
        try {
            wallpaperManager.setBitmap(bitmap)
            Toast.makeText(applicationContext, "Wallpaper Changed!", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
        }
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