package com.example.kotlinapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapp.DataArrayList.TitleListCategory
import com.example.kotlinapp.RecyclerView.*
import com.example.kotlinapp.databinding.FragmentItemFirstBinding

class FragmentItemFirst : Fragment() {
	private val adapterFirst = rcAdapterCardCategoryFirst()
	private val adapterSecond = rcAdapterCardCategorySecond()
	private val adapterThird = rcAdapterCardCategoryThird()

	private val listTitleCategory = listOf("Cleaner","Plumber","Electrican","Gardener","Text5","Text6","Text7")
	private val listTitleCleaning = listOf("Home Cleaning","Bathroom Cleaning","Disinfection","Title1","Title2","Title3","Title4")
	private val listTitleRepairs = listOf("Plumber","Carpenter","Title1","Title2","Title3","Title4","Title5")


	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		val binding = FragmentItemFirstBinding.inflate(inflater, container,false)
		binding.apply {

			// как будет заполняться список
			rcCategory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
			// выбрать адаптер
			rcCategory.adapter = adapterFirst
			for (i in listTitleCategory.indices) adapterFirst.addItem(TitleListCategory(listTitleCategory[i]))

			rcCleaningServices.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
			// выбрать адаптер
			rcCleaningServices.adapter = adapterSecond
			for (i in listTitleCategory.indices) adapterSecond.addItem(TitleListCategory(listTitleCleaning[i]))

			rcHomeRapairs.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
			// выбрать адаптер
			rcHomeRapairs.adapter = adapterThird
			for (i in listTitleCategory.indices) adapterThird.addItem(TitleListCategory(listTitleRepairs[i]))

		}
		return binding.root
	}

	companion object {
		@JvmStatic
		fun newInstance() = FragmentItemFirst()
	}
}