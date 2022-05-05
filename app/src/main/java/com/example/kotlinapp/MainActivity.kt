package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	// создаем экземпляр класса адаптера
	private val adapter = AdapterRecyclerView()
	private var index = 0

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)

		init()
	}

	// инициализируем recyclerview
	private fun init(){
		// выводим список и проверяем index меньше размера массива, если да, то выводим дальше
		while (index < DataSights.imageIdList.size) {
			// apply выбираем элементы без binding.
			binding.apply {
				//выбираем как ориентацию
				// rcView.layoutManager = LinearLayoutManager(this@MainActivity) - выведет ГОРИЗОНТАЛЬНО
				// (выбираем context, пишем количество столбцов)
				rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
				// выбираем адаптер
				rcView.adapter = adapter
				val image = DataSights.imageIdList[index]
				val title = DataSights.titleList[index]
				val descr = DataSights.descriptionList[index]
				val sight = SightsActivity(
					image,
					title,
					descr
				)
				adapter.addSight(sight)
				index++
			}
		}
	}
}