package com.example.travelapplagi.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.travelapplagi.model.Order
import com.example.travelapplagi.user.OrderHistoryFragment

class OrderHistoryPopupDialog(private val order: Order,
                              private val historyFragment: OrderHistoryFragment)
    : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        builder.apply {
            setTitle("Batalkan perjalanan?")
            setMessage("Batalkan perjalanan yang kamu pesan ini?")
            setPositiveButton("Hapus") { dialog, which->
                historyFragment.deleteOrder(order)
                dismiss()
            }
        }
        return builder.create()
    }

}