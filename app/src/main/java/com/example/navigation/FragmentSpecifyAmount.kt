package com.example.navigation

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.databinding.FragmentSpecifyAmountBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import kotlinx.android.synthetic.main.payment_successsful_dialog.*


class FragmentSpecifyAmount : Fragment() {

    private var _binding: FragmentSpecifyAmountBinding? = null
    private val binding: FragmentSpecifyAmountBinding get() = _binding!!
    private val args: FragmentSpecifyAmountArgs by navArgs()
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpecifyAmountBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        val receiverName = args.receiverName
        binding.textView2.text = "Send Money to - $receiverName"


        binding.btnSend.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext(), R.style.NewDialog)
            dialog.setContentView(R.layout.payment_successsful_dialog)
            dialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialog.txtVw_dailog.text = "Do you want to pay Rs- ${binding.edtTxtEnterAmount.text}  to Mr. - $receiverName "

            dialog.btn_confirm.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "Payment Successful to: $receiverName - Rs- ${edtTxt_enterAmount.text}",
                    Toast.LENGTH_SHORT
                ).show()
                dialog.cancel()
            }
            dialog.btn_discard.setOnClickListener {
                dialog.cancel()
            }

            dialog.setCancelable(true)
            dialog.show()

        }

        binding.btnHome.setOnClickListener {
            val action =
                FragmentSpecifyAmountDirections.actionFragmentSpecifyAmountToHomeFragment()
            findNavController().navigate(action)
        }

        binding.btnBack2.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment,true)
        }


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}