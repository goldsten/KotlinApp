package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)

		// получаем toolbar
		supportActionBar?.setDisplayHomeAsUpEnabled(true)
		// изменяем title
		supportActionBar?.title = "My Action Bar"
	}
	//функция выводит меню на экран
	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		//создаем разметку меню
		// (выбираем макет меню, в какое меню хотим поместить наш макет)
		menuInflater.inflate(R.menu.menu_toolbar, menu)
		return true
	}
	// прослушивает нажатие на какой то элемент в toolbar
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		// слушатель нажатий
		// проверяем или нажали то что нужно
		// ndroid.R.id.home - так как это встроенный toolbar и его элемент, берем его из android
		when(item.itemId){
			// стрелка назад это дефолтный ид, по этому android.R.id.
			android.R.id.home -> Toast.makeText(this, "Tap back", Toast.LENGTH_SHORT).show()
			// это созданый ид, по этому без android
			R.id.newTitle -> Toast.makeText(this, "Tap menu", Toast.LENGTH_SHORT).show()
		}

		return true
	}
}