package com.example.appdemo5.ui.shop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.appdemo5.R
import com.example.appdemo5.databinding.CellShopBinding
import com.example.appdemo5.model.shop.Product

class ShopAdapter : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    var list = listOf<Product>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    /* click listener */
    private var _onItemAddListener: ((Product) -> Unit)? = null

    fun setOnItemAddListener(listener: (Product) -> Unit) {
        _onItemAddListener = listener
    }

    inner class ShopViewHolder(val binding: CellShopBinding) : RecyclerView.ViewHolder(binding.root)  {
        init {
            binding.btAddToCart.setOnClickListener {
                _onItemAddListener?.invoke(list[adapterPosition])
            }
        }

        fun bind(product: Product) {
            binding.tvProductName.text = product.name
            binding.tvPrice.text = "${product.price}"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        return ShopViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.cell_shop, parent, false
            )
        )
    }



    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


}