package com.example.mytest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.mytest.adapter.ImageSliderAdapter
import com.example.mytest.databinding.ActivityScrollingBinding
import com.example.mytest.modal.DataSource

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding
    private lateinit var viewModel: MyViewModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))

        viewModel = ViewModelProvider(this)[MyViewModal::class.java]

        setParentImageSlider()
        setSublistItems()

        binding.search.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.subListAdapter.filter.filter(newText.toString())
                return true
            }

        })

    }

    private fun setParentImageSlider() {
        binding.viewPager.adapter = viewModel.imageSliderAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)


        binding.viewPager.addOnPageChangeListener(
            object : ViewPager.OnPageChangeListener{
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                }

                override fun onPageSelected(position: Int) {
                    viewModel.subListAdapter.updateList(DataSource.getParentImages()[position].sublistItems)
                }

                override fun onPageScrollStateChanged(state: Int) {

                }

            })
        }


    private fun setSublistItems() {
        binding.recyclerView.adapter = viewModel.subListAdapter
    }
}