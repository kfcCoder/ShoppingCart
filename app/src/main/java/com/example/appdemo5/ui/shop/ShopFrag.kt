package com.example.appdemo5.ui.shop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appdemo5.R
import com.example.appdemo5.databinding.FragShopBinding
import com.example.appdemo5.ui.shop.adapter.ShopAdapter
import com.example.appdemo5.viewmodel.MyViewModel

class ShopFrag : Fragment() {

    private val TAG = ShopFrag::class.java.simpleName

    private lateinit var binding: FragShopBinding

    private val viewModel by activityViewModels<MyViewModel>()

    private val shopAdapter = ShopAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_shop, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvShop.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = shopAdapter
            addItemDecoration(DividerItemDecoration(requireActivity(), DividerItemDecoration.HORIZONTAL))
        }

        viewModel.productListLive().observe(viewLifecycleOwner) {
            shopAdapter.list = it
            Log.e(TAG, "productList: $it")
        }



    }



}