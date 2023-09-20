package com.example.lovecalculatoronfragment.ui.history

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.lovecalculatoronfragment.R
import com.example.lovecalculatoronfragment.databinding.FragmentHistoryBinding
import com.example.lovecalculatoronfragment.model.LoveModel
import com.example.lovecalculatoronfragment.presenter.HistoryPresenter
import com.example.lovecalculatoronfragment.presenter.ResultPresenter
import com.example.lovecalculatoronfragment.view.HistoryView
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment(), HistoryView, HistoryAdapter.Listener {

    private lateinit var binding: FragmentHistoryBinding

    private val adapter = HistoryAdapter(this)

    @Inject
    lateinit var historyPresenter: HistoryPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        historyPresenter.attachView(this)
        historyPresenter.getHistoryList()

    }

    override fun onLongClickItem(loveModel: LoveModel) {
        showDeleteDialog(loveModel)

    }

    override fun onClickItem(loveModel: LoveModel) {
        historyPresenter.getDate(loveModel)
    }

    override fun initRecyclerView(historyList: List<LoveModel>) {
        binding.rcVHistory.adapter = adapter
        adapter.addLove(historyList)
    }

    override fun showDeleteDialog(loveModel: LoveModel) {
        val alertBuilder = AlertDialog.Builder(requireContext())
        alertBuilder.setTitle(getString(R.string.delete))
        alertBuilder.setMessage(getString(R.string.delete_message))
        alertBuilder.setPositiveButton(getString(R.string.yes)) { _, _ ->
            historyPresenter.deleteItem(loveModel)
        }
        alertBuilder.setNeutralButton("Cancel")
        { _, _ ->
        }
        alertBuilder.show()
    }



    override fun showDateDialog(time: Long) {
        val alertDialog = AlertDialog.Builder(requireContext())


        alertDialog.setTitle(getString(R.string.date_of_creation))
            .setMessage(SimpleDateFormat("d MMM yyyy HH:mm:ss").format(time))
            .setNegativeButton(getString(R.string.cancel)) { _, _ -> }.show()
    }


}

