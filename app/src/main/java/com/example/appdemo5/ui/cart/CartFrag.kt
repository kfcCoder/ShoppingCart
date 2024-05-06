package com.example.appdemo5.ui.cart

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.appdemo5.R
import com.example.appdemo5.databinding.FragCartBinding
import com.example.appdemo5.viewmodel.MyViewModel

class CartFrag : Fragment() {

    private val TAG = CartFrag::class.java.simpleName

    private lateinit var binding: FragCartBinding

    private val viewModel by activityViewModels<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_cart, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getCartItemsLive().observe(viewLifecycleOwner) {
            Log.e(TAG, "cartItems: $it")
        }

        // navigate up
        binding.icBack.setOnClickListener {
            findNavController().navigateUp()
        }

    }



}