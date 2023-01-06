package com.example.mytest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.mytest.databinding.ItemImageSliderBinding
import com.example.mytest.modal.ParentImageSlider

class ImageSliderAdapter(private val images: List<ParentImageSlider>) :
    PagerAdapter() {

    private lateinit var context: Context

    override fun getCount(): Int = images.size

    override fun getPageWidth(position: Int): Float {
        return .9f
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        context = container.context
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = ItemImageSliderBinding.inflate(layoutInflater)
        binding.ivCarousel.setImageDrawable(ContextCompat.getDrawable(context, images[position].imageResource))
        container.addView(binding.root)
        return binding.root
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean =
        view === `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View?)
    }
}