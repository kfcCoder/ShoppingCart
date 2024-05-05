package com.example.appdemo5.ui.cart.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.appdemo5.R
import com.example.appdemo5.databinding.CellCartBinding
import com.example.appdemo5.model.cart.CartItem

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    var list = listOf<CartItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /* click listener */
    private var _onItemClickListener: ((CartItem) -> Unit)? = null

    fun setOnItemClickListener(listener: (CartItem) -> Unit) {
        _onItemClickListener = listener
    }

    inner class CartViewHolder(val binding: CellCartBinding) : RecyclerView.ViewHolder(binding.root)  {
        init {

        }

        fun bind(item: CartItem) {
            binding.tvProductName.text = item.product.name
            //binding.tvItemTotalPrice.text =

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.cell_cart, parent, false
            )
        )
    }



    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}