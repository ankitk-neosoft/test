package com.example.mytest

import androidx.lifecycle.ViewModel
import com.example.mytest.adapter.ImageSliderAdapter
import com.example.mytest.adapter.SubListAdapter
import com.example.mytest.modal.DataSource

class MyViewModal : ViewModel() {
    var imageSliderAdapter = ImageSliderAdapter(DataSource.getParentImages())
    var subListAdapter = SubListAdapter(DataSource.getPizza())
}