package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.navigation.R
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list_lv.adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,getNotifications())
    }

    private fun getNotifications(): List<String> {
        val notification = mutableListOf<String>()

        for (i in 1..20){
            notification.add("notification - $i")
        }
        return notification
    }
}