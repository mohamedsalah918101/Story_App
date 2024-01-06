package com.petra.story

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class ImageFragment : Fragment() {
    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_image, container, false)
        imageView = view.findViewById(R.id.imageInFragment)
        return view
    }
    fun displayImage(imageRes: Int) {
        imageView.setImageResource(imageRes)
        Handler(Looper.getMainLooper()).postDelayed({
            imageView.setImageDrawable(null)
        }, 3000) // 3 seconds
    }
}