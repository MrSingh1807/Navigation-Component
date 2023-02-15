package com.example.navigation

import android.app.PendingIntent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentChooseReceiverBinding


class FragmentChooseReceiver : Fragment() {

    private var _binding: FragmentChooseReceiverBinding? = null

    private val binding: FragmentChooseReceiverBinding get() = _binding!!
    private lateinit var mManager: NotificationManagerCompat

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseReceiverBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        mManager = context?.let { NotificationManagerCompat.from(it) }!!

        binding.btnNxt.setOnClickListener {
            val name = binding.edtTxtChooseReceiver.text.toString()

            val pendingIntent = findNavController()
                .createDeepLink()
                .setGraph(R.navigation.main_nav_host)
                .setDestination(R.id.fragmentSpecifyAmount)
                .setArguments(FragmentSpecifyAmountArgs(name, 0).toBundle())
                .createPendingIntent()

            showNotification(pendingIntent, name)

            val action =
                FragmentChooseReceiverDirections.actionFragmentChooseReceiverToFragmentSpecifyAmount(
                    name,
                    200
                )
            findNavController().navigate(action)
        }
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

    private fun showNotification(pendingIntent: PendingIntent, name: String) {


        val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(android.R.drawable.stat_notify_chat)
            .setContentTitle("Complete Transaction")
            .setContentText("Send Money to Mr $name")
            .setContentIntent(pendingIntent)
            .build()

        mManager.notify(100, notification)

    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

}