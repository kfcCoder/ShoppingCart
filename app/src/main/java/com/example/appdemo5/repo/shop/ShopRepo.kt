package com.example.appdemo5.repo.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appdemo5.model.shop.Product

class ShopRepo {

    init {
        loadProducts()
    }

    private val _productListLive = MutableLiveData<List<Product>>()
    val productListLive: LiveData<List<Product>> = _productListLive


    private fun loadProducts() {
        val products = mutableListOf<Product>()
        products.add(Product(id = "101", name = "banana", price = 10, imageUrl = ""))
        products.add(Product(id = "102", name = "orange", price = 15, imageUrl = ""))
        products.add(Product(id = "103", name = "grape", price = 20, imageUrl = ""))
        products.add(Product(id = "104", name = "watermelon", price = 25, imageUrl = ""))

        _productListLive.postValue(products)
    }



}