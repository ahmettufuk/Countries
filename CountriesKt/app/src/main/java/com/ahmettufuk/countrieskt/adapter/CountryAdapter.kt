package com.ahmettufuk.countrieskt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ahmettufuk.countrieskt.R
import com.ahmettufuk.countrieskt.databinding.ItemCountryBinding
import com.ahmettufuk.countrieskt.model.Country
import com.ahmettufuk.countrieskt.util.downloadFromUrl
import com.ahmettufuk.countrieskt.util.placeholdeProgressBar
import com.ahmettufuk.countrieskt.view.CountryFragment
import com.ahmettufuk.countrieskt.view.CountryFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList: ArrayList<Country>):RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(),CountryClickListener {

    class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.item_country,parent,false)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(inflater,R.layout.item_country,parent,false)
        return CountryViewHolder(view)

    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.country = countryList[position]
        holder.view.listener = this


       /*
       holder.view.setOnClickListener {
            val action = CountryFragmentDirections.actionCountryFragmentToDetailFragment(countryList[position].uuid)
            //action.countryuuid
            Navigation.findNavController(it).navigate(action)
        }

        holder.view.imageView.downloadFromUrl(countryList[position].flagImageUrl,
            placeholdeProgressBar(holder.view.context))

        */


    }

    override fun getItemCount(): Int {
        return countryList.size

    }

    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

    override fun onCountryClickListener(v: View) {
        val uuid = v.countryUuidText.text.toString().toInt()
        val action = CountryFragmentDirections.actionCountryFragmentToDetailFragment(uuid)
        //action.countryuuid
        Navigation.findNavController(v).navigate(action)
    }
}