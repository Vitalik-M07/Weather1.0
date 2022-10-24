package com.hfad.openweather.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.openweather.MainViewModel
import com.hfad.openweather.adapters.WeatherAdapter
import com.hfad.openweather.adapters.WeatherModel
import com.hfad.openweather.databinding.FragmentHoursBinding
import org.json.JSONArray
import org.json.JSONObject


class Hours : Fragment() {


    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter
    private val model: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
        model.liveDataCurrent.observe(viewLifecycleOwner) {

            adapter.submitList(getHoursList(it))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initRcView() = with(binding) {
        rsView.layoutManager = LinearLayoutManager(activity)

        adapter = WeatherAdapter(null)
        rsView.adapter = adapter

    }

    private fun getHoursList(wItem: WeatherModel): List<WeatherModel> {
        val hoursArray = JSONArray(wItem.hours)
        val list = ArrayList<WeatherModel>()
        for (i in 0 until hoursArray.length()) {
            val item = WeatherModel(
                "",
                (hoursArray[i] as JSONObject).getString("time"),
                (hoursArray[i] as JSONObject).getJSONObject("condition").getString("text"),
                (hoursArray[i] as JSONObject).getString("temp_c"),
                "",
                "",
                (hoursArray[i] as JSONObject).getJSONObject("condition").getString("icon"),
                ""
            )
            list.add(item)
        }

return  list
    }

    companion object {

        @JvmStatic
        fun newInstance() = Hours()
    }
}
