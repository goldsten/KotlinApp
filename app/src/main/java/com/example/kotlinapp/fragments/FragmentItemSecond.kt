package com.example.kotlinapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinapp.R
import com.example.kotlinapp.databinding.FragmentItemSecondBinding

class FragmentItemSecond : Fragment() {


	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val binding = FragmentItemSecondBinding.inflate(inflater)
		return binding.root
	}

	companion object {
		@JvmStatic
		fun newInstance() = FragmentItemSecond()
	}
}