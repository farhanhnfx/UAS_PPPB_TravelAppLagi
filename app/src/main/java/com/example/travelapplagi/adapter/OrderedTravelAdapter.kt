package com.example.travelapplagi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemLongClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.travelapplagi.databinding.OrderedCardBinding
import com.example.travelapplagi.model.Order
import com.google.firebase.firestore.FirebaseFirestore

class OrderedTravelAdapter(private val listOrder: List<Order>,
                            private val onItemLongClickListener: (Order)-> Unit)
    : RecyclerView.Adapter<OrderedTravelAdapter.ItemOrderViewHolder>() {

    inner  class ItemOrderViewHolder(private val binding: OrderedCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(order: Order) {
            with(binding) {
                txtTitle.text = order.title
                txtDate.text = order.date
                txtDesc.text = order.desc
                txtPaket.text = order.selectedPaket.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemOrderViewHolder {
        val binding = OrderedCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemOrderViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOrder.size
    }

    override fun onBindViewHolder(holder: ItemOrderViewHolder, position: Int) {
        val order = listOrder[position]
        holder.bind(order)
        holder.itemView.setOnLongClickListener {
            onItemLongClickListener(order)
            true
        }
    }
}