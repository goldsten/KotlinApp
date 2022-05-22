package com.example.kotlinapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.RecyclerView.TitleList
import com.example.kotlinapp.RecyclerView.rcAdapter
import com.example.kotlinapp.databinding.FragmentItemFirstBinding

class FragmentItemFirst : Fragment() {
	private val adapter = rcAdapter()
	private val listTitle = listOf("Cleaner","Plumber","Electrican","Gardener","Text5","Text6","Text7",)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		val binding = FragmentItemFirstBinding.inflate(inflater, container,false)
		binding.apply {
			// как будет заполняться список
			rcCategory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
			// выбрать адаптер
			rcCategory.adapter = adapter
			for (i in listTitle.indices){
				val title = TitleList(listTitle[i])
				adapter.addItem(title)
			}
		}
		return binding.root
	}

	companion object {
		@JvmStatic
		fun newInstance() = FragmentItemFirst()
	}
}