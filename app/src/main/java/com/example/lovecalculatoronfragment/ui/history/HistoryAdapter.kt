package com.example.lovecalculatoronfragment.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculatoronfragment.databinding.ItemHistoryBinding
import com.example.lovecalculatoronfragment.model.LoveModel

class HistoryAdapter(private val listener: Listener) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private val historyList = arrayListOf<LoveModel>()

    fun addLove(loveModel: List<LoveModel>) {
        historyList.clear()
        historyList.addAll(loveModel)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(historyList[position],listener)
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    inner class ViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loveModel: LoveModel,listener: Listener) {
            binding.firstTv.text = loveModel.firstName
            binding.secondTv.text = loveModel.secondName
            binding.percentTv.text = loveModel.percentage
            binding.resTv.text = loveModel.result
            binding.root.setOnClickListener {
                listener.onClickItem(loveModel)
            }
            itemView.setOnLongClickListener {
                listener.onLongClickItem(loveModel)
                true
            }

        }

    }

    interface Listener {
        fun onLongClickItem(loveModel: LoveModel)
        fun onClickItem(loveModel: LoveModel)
    }


}