package com.example.appdemo5.viewmodel

import androidx.lifecycle.ViewModel
import com.example.appdemo5.model.cart.CartItem
import com.example.appdemo5.model.shop.Product
import com.example.appdemo5.repo.cart.CartRepo
import com.example.appdemo5.repo.shop.ShopRepo


class MyViewModel : ViewModel() {

    /**
     * for DataBinding in fragment_product_detail.xml

    private val productLive = MutableLiveData<Product>()

    fun setProductLive(product: Product) { // set at ShopFragment#onItemClick(Product product) callback
        productLive.value = product
    }

    fun getProductLive(): LiveData<Product>? {
        return productLive
    }*/




    /* shop*/
    private val shopRepo = ShopRepo()

    fun getProductListLive() = shopRepo.productListLive


    /* cart */
    private val cartRepo = CartRepo()

    fun getCartItemsLive() = cartRepo.cartItemsLive


    fun addItemToCart(product: Product): Boolean {
        return cartRepo.addItemToCart(product)
    }

    fun changeQty(cartItem: CartItem, qty: Int) {
        cartRepo.changeQty(cartItem, qty)
    }


    /*
    fun removeItemFromCart(cartItem: CartItem) {
        //cartRepo.removeItemFromCart(cartItem)
    }


    fun getTotalPrice() = cartRepo.totalPriceLive


    fun resetCart() {
        cartRepo.initCart()
    }*/
}