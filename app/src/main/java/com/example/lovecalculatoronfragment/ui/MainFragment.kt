package com.example.lovecalculatoronfragment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculatoronfragment.R
import com.example.lovecalculatoronfragment.databinding.FragmentMainBinding
import com.example.lovecalculatoronfragment.model.LoveModel
import com.example.lovecalculatoronfragment.presenter.Presenter
import com.example.lovecalculatoronfragment.view.LoveView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(), LoveView {
    private lateinit var bindig: FragmentMainBinding

    @Inject
    lateinit var presenter: Presenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindig = FragmentMainBinding.inflate(inflater, container, false)
        return bindig.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attchView(this)
        presenter.showOnBoarding()
        initClickers()

    }

    private fun initClickers() {
        with(bindig) {
            calculateBtn.setOnClickListener {
                presenter.getLoveResult(firstEd.text.toString(), secondEd.text.toString())
            }
        }
    }

    override fun navigationToResultScreen(loveModel: LoveModel) {
        findNavController().navigate(R.id.resultFragment, bundleOf("love" to loveModel))
    }

    override fun showError(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    override fun navigationToOnBoarding() {
        findNavController().navigate(R.id.onBoardingFragment)

    }


}