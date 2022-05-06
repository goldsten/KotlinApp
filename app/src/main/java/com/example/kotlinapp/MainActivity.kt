package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
	// прослушивает нажатие на какой то элемент в toolbar
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		// слушатель нажатий
		// проверяем или нажали то что нужно
		// ndroid.R.id.home - так как это встроенный toolbar и его элемент, берем его из android
		if(item.itemId == android.R.id.home) Toast.makeText(this, "Tap back", Toast.LENGTH_SHORT).show()
		return true
	}
}