package com.petra.story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var fragmentContainer: FrameLayout
    private lateinit var imageFragment: ImageFragment
    private val images = listOf(R.drawable.buffon, R.drawable.varane, R.drawable.casemiro, R.drawable.kroos, R.drawable.modric, R.drawable.leva2, R.drawable.messi, R.drawable.ronaldo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        fragmentContainer = findViewById(R.id.fragmentContainer)
        imageFragment = ImageFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, imageFragment)
            .commit()

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        val adapter = ImageAdapter(images) { imageRes ->
            displayImageInFragment(imageRes)
        }
        recyclerView.adapter = adapter

    }
    private fun displayImageInFragment(imageRes: Int) {
        imageFragment.displayImage(imageRes)
    }
}
