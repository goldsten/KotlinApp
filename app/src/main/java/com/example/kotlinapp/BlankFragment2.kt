package com.example.kotlinapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.kotlinapp.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {
	lateinit var binding: FragmentBlank2Binding
	private val dataModel: DataModel by activityViewModels()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		binding = FragmentBlank2Binding.inflate(inflater)
		return binding.root
	}

	// когда разметка создана через onViewCreated можем найти id элементы
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		// следит за обновлением данных в messageFragment2
		dataModel.messageFragment2.observe(activity as LifecycleOwner, {
			binding.textView.text = it
		})
		//отправляем данные в фрагмент 1
		binding.sendFrag1.setOnClickListener {
			// value изменяем значение
			dataModel.messageFragment1.value = "Msg: Fragment 2"
		}
		//отправляем данные в активити
		binding.sendActivity.setOnClickListener {
			// value изменяем значение
			dataModel.messageActivity.value = "Msg: Activity from fragment 2"
		}
	}

	companion object {
		@JvmStatic
		fun newInstance() = BlankFragment2()
	}
}