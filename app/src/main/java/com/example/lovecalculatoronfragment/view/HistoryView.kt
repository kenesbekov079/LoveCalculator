package com.example.lovecalculatoronfragment.view

import com.example.lovecalculatoronfragment.model.LoveModel

interface HistoryView {

    fun initRecyclerView(historyList: List<LoveModel>)

    fun showDeleteDialog(loveModel: LoveModel)

    fun showDateDialog(time: Long)
}