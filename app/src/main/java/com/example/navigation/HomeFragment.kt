package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var binding: FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        binding!!.btnSendMoney.setOnClickListener {
           val action =
               HomeFragmentDirections.actionHomeFragmentToFragmentChooseReceiver()
           findNavController().navigate(action)
       }

        binding!!.btnViewTrans.setOnClickListener {
           val action =  HomeFragmentDirections.actionHomeFragmentToViewTransactionsFragment()
            findNavController().navigate(action)
        }

        binding!!.btnViewBalence.setOnClickListener {
            val action =  HomeFragmentDirections.actionHomeFragmentToViewBalanceFragment()
            findNavController().navigate(action)

        }

        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}