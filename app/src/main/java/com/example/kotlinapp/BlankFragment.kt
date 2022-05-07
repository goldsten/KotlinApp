package com.example.kotlinapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinapp.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		// binding
		val binding = FragmentBlankBinding.inflate(inflater)
		return binding.root
	}

	// когда разметка создана через onViewCreated можем найти id элементы
	/*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
	}*/

	companion object {
		@JvmStatic
		fun newInstance() = BlankFragment()

	}
}