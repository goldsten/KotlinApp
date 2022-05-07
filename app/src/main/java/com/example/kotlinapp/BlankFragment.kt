package com.example.kotlinapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.kotlinapp.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
	private val dataModel: DataModel by activityViewModels()
	lateinit var binding: FragmentBlankBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		binding = FragmentBlankBinding.inflate(inflater)
		return binding.root
	}

	// когда разметка создана через onViewCreated можем найти id элементы
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		// следит за обновлением данных в messageFragment1
		dataModel.messageFragment1.observe(activity as LifecycleOwner, {
			binding.textView.text = it
		})
		//отправляем данные в фрагмент 2
		binding.sendFrag2.setOnClickListener {
			// value изменяем значение
			dataModel.messageFragment2.value = "Msg: Fragment 1"
		}
		//отправляем данные в активити
		binding.sendActivity.setOnClickListener {
			// value изменяем значение
			dataModel.messageActivity.value = "Msg: Activity from fragment 1"
		}
	}

	companion object {
		@JvmStatic
		fun newInstance() = BlankFragment()
	}
}