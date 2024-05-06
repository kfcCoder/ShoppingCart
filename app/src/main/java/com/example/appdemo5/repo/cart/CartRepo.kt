package com.example.appdemo5.repo.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appdemo5.model.cart.CartItem
import com.example.appdemo5.model.shop.Product


class CartRepo {

    private val _cartItemsLive = MutableLiveData<List<CartItem>>()
    val cartItemsLive: LiveData<List<CartItem>> = _cartItemsLive

    private val _totalPriceLive = MutableLiveData<Int>()
    val totalPriceLive: LiveData<Int> = _totalPriceLive


    init {
        initCart()
        initPriceLive()
    }

    private fun initCart() {
        _cartItemsLive.postValue(listOf())
        calculateTotalPrice()
    }

    private fun initPriceLive() {
        _totalPriceLive.postValue(0)
    }



    fun addItemToCart(product: Product): Boolean {
        val list = _cartItemsLive.value ?: return false
        val cartItemList = list.toMutableList()

        // add existing item
        for (item in cartItemList) {
            if (item.product.id == product.id) {
                val idx = cartItemList.indexOf(item)
                item.quantity = item.quantity + 1
                cartItemList[idx] = item
                _cartItemsLive.postValue(cartItemList)

                calculateTotalPrice()
                return true
            }
        }

        // add new item
        val cartItem = CartItem(product = product, quantity = 1)
        cartItemList.add(cartItem)
        _cartItemsLive.postValue(cartItemList)
        calculateTotalPrice()
        return true
    }

    private fun calculateTotalPrice() {
        var total = 0
        val cartItemList = cartItemsLive.value ?: return

        for (item in cartItemList) {
            total += item.product.price * item.quantity
        }

        _totalPriceLive.postValue(total)
    }

    fun changeQty(cartItem: CartItem, quantity: Int) {
        val list = _cartItemsLive.value ?: return
        val cartItemList = list.toMutableList()

        val updatedItem = CartItem(cartItem.product, quantity)
        cartItemList[cartItemList.indexOf(cartItem)] = updatedItem
        _cartItemsLive.postValue(cartItemList)
        calculateTotalPrice()
    }


    /*
    fun removeItemFromCart(cartItem: CartItem) {
        if (cartItemsLive.value == null) {
            return
        }
        val cartItemsList: MutableList<CartItem> = ArrayList(cartItemsLive.value)
        cartItemsList.remove(cartItem)
        cartItemsLive.setValue(cartItemsList)
        calculateTotalPrice()
    }*/




}