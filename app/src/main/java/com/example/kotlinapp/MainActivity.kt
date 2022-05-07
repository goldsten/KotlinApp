package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)

		//слушатель
		binding.button.setOnClickListener {
			supportFragmentManager
				//запускаем фрагмент
				.beginTransaction()
				//заменяем один фрагмент на другой
				//разметка, запуск
				//BlankFragment. newInstance() - проверит запущено ли и если нет то запустит или перезапустит фрагмент
				//.commit()
				.replace(R.id.place_holder, BlankFragment2.newInstance())
				.commit()
		}

		//показываем фрагмент
		supportFragmentManager
			//запускаем фрагмент
			.beginTransaction()
			//заменяем один фрагмент на другой
			//разметка, запуск
			//BlankFragment. newInstance() - проверит запущено ли и если нет то запустит или перезапустит фрагмент
			//.commit()
			.replace(R.id.place_holder, BlankFragment.newInstance())
			.commit()

	}
}