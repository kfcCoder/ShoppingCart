package com.example.appdemo5.model.cart

import com.example.appdemo5.model.shop.Product

data class CartItem(
    val product: Product,
    var quantity: Int, // mutable
)
