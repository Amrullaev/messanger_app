package com.example.telegram_demo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.telegram_demo.data.Message
import com.example.telegram_demo.databinding.ItemFromBinding
import com.example.telegram_demo.databinding.ItemToBinding

class MessageAdapter(val list: List<Message>, val myUid: String) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val FROM = 0
    val TO = 0

    inner class FromVh(var itemFromBinding: ItemFromBinding) :
        RecyclerView.ViewHolder(itemFromBinding.root) {
        fun onBind(m: Message) {
            itemFromBinding.messageFrom.text = m.message
        }
    }

    inner class ToVh(var itemToBinding: ItemToBinding) :
        RecyclerView.ViewHolder(itemToBinding.root) {
        fun onBind(m: Message) {
            itemToBinding.messageTo.text = m.message
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (myUid == list[position].from) {
            0
        } else {
            1

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == FROM) {
            FromVh(
                ItemFromBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            ToVh(ItemToBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == FROM) {
            val fromVh = holder as FromVh
            fromVh.onBind(list[position])
        } else {
            val toVh = holder as ToVh
            toVh.onBind(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}