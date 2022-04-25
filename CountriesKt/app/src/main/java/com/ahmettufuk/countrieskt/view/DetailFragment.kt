package com.ahmettufuk.countrieskt.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.ahmettufuk.countrieskt.R
import com.ahmettufuk.countrieskt.databinding.FragmentDetailBinding
import com.ahmettufuk.countrieskt.util.downloadFromUrl
import com.ahmettufuk.countrieskt.util.placeholdeProgressBar
import com.ahmettufuk.countrieskt.viewmodel.CountryViewModel
import com.ahmettufuk.countrieskt.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import java.util.*


class DetailFragment : Fragment() {
    private var countryUUID = 0
    private val viewModel : DetailViewModel by viewModels()
    private lateinit var dataBinding: FragmentDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            countryUUID = DetailFragmentArgs.fromBundle(it).countryUuid

        }
        viewModel.getDataFromRoom(countryUUID)
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.countryLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it?.let {

                dataBinding.selectedCountry = it
                /*
                countryNameDetail.text = it.countryName
                capitalNameDetail.text= it.capitalName
                languageNameDetail.text = it.Language
                regionNameDetail.text = it.regionName
                currencyNameDetail.text = it.currencyName
                context?.let { context ->
                    countryFlagImage.downloadFromUrl(it.flagImageUrl, placeholdeProgressBar(context))
                }

                 */


            }
        })

    }


}