package com.example.kotlinapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinapp.databinding.FragmentItemFourthBinding

class FragmentItemFourth : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val binding = FragmentItemFourthBinding.inflate(inflater)
		return binding.root
	}

	companion object {
		@JvmStatic
		fun newInstance() = FragmentItemFourth()

	}
}