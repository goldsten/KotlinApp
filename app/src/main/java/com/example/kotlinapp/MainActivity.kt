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

		// что бы выбрать стартовый item
		binding.bottomNavBar.selectedItemId = R.id.menu_add

		// создаем слушатель
		binding.bottomNavBar.setOnItemSelectedListener {
			// проверяем id нажатого элемента
			when(it.itemId){
				R.id.menu_home -> binding.txtView.text = "Home Activity"
				R.id.menu_search -> binding.txtView.text = "Search Activity"
				R.id.menu_add -> binding.txtView.text = "Add Activity"
				R.id.menu_liked -> binding.txtView.text = "Liked Activity"
				R.id.menu_profile -> binding.txtView.text = "Profile Activity"
			}

			// функция должна возвращать boolean
			true
		}
	}
}