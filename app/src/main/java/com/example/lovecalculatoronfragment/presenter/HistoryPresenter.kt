package com.example.lovecalculatoronfragment.presenter

import com.example.lovecalculatoronfragment.model.LoveModel
import com.example.lovecalculatoronfragment.model.room.LoveDao
import com.example.lovecalculatoronfragment.view.HistoryView
import com.example.lovecalculatoronfragment.view.ResultView
import javax.inject.Inject



    class HistoryPresenter @Inject constructor(private val loveDao: LoveDao) {

        private lateinit var historyView: HistoryView
        fun getHistoryList() {
            historyView.initRecyclerView(loveDao.getAll())
        }

        fun deleteItem(loveModel: LoveModel) {
            loveDao.delete(loveModel)
            getHistoryList()
        }

        fun getDate(loveModel: LoveModel) {
            loveModel.time?.let { historyView.showDateDialog(it) }
        }

        fun attachView(view: HistoryView){
            historyView = view
        }
    }