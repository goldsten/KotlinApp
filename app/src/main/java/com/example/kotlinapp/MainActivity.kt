package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	private val dataModel : DataModel by viewModels()

	//appserver - наблюдает за данными когда можно обновить данные

	override fun onCreate(s: Bundle?) {
		super.onCreate(s)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)


		//показываем фрагмент
		//BlankFragment. newInstance() - проверит запущено ли и если нет то запустит или перезапустит фрагмент
		openFragment(R.id.frame1, BlankFragment.newInstance())
		openFragment(R.id.frame2, BlankFragment2.newInstance())

		//Lifecycle передаем у кого следить за циклом жизни (this)
		dataModel.messageActivity.observe(this, {
			// обновиться когда запуститься что то в message
			binding.tvActivity.text = it
		})

	}

	private fun openFragment(frame: Int, f: Fragment){
		supportFragmentManager
			//запускаем фрагмент
			.beginTransaction()
			//заменяем один фрагмент на другой
			//разметка, запуск
			//BlankFragment. newInstance() - проверит запущено ли и если нет то запустит или перезапустит фрагмент
			.replace(frame, f)
			//.commit()
			.commit()
	}
}