package com.example.mytest.modal

import com.example.mytest.R

object DataSource {
    fun getParentImages() = mutableListOf<ParentImageSlider>().apply {
        add(ParentImageSlider(R.drawable.img_pizza, getPizza()))
        add(ParentImageSlider(R.drawable.img_bike, getBike()))
        add(ParentImageSlider(R.drawable.img_flower, getFlower()))
        add(ParentImageSlider(R.drawable.img_food, getFood()))
    }

    fun getFlower() = arrayListOf<SublistItems>().apply {
        add(SublistItems("Lace leaf"))
        add(SublistItems("Aster"))
        add(SublistItems("Bluebell"))
        add(SublistItems("Calla Lily"))
        add(SublistItems("Carnations"))
    }


    fun getFood() = arrayListOf<SublistItems>().apply {
        add(SublistItems("Appam - India"))
        add(SublistItems("Chhat - India"))
        add(SublistItems("khichdi - India"))
        add(SublistItems("Chicken 65 - India"))
        add(SublistItems("Chilli Crab - Singapore"))
        add(SublistItems("Dal Makhani - India"))
        add(SublistItems("Gulab Jamun - India"))
        add(SublistItems("Kulfi - India"))

    }


    fun getPizza() = arrayListOf<SublistItems>().apply {
        add(SublistItems("Aussie Pizza"))
        add(SublistItems("BBQ Chicken Pizza"))
        add(SublistItems("Cheese Corn Pizza"))

    }

    fun getBike() = arrayListOf<SublistItems>().apply {
        add(SublistItems("Honda RVT RC51"))
        add(SublistItems("2002 Suzuki GSX"))
        add(SublistItems("Ducati Desmosedici"))
        add(SublistItems("Kawasaki Ninja"))
        add(SublistItems("Ktm 500cc"))
        add(SublistItems("Ktm 950 Adventure"))
        add(SublistItems("MV Agusta F4cc"))
        add(SublistItems("Royal Enfield"))
        add(SublistItems("Suzuki Motorcycle"))
        add(SublistItems("UM Motorcycles"))
        add(SublistItems("Yamaha R 15S"))
    }

}