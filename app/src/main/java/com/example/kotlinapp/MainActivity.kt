package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)

		// открытие sidebar
		binding.apply {
			open.setOnClickListener {
				// выбираем кнопку, по нажатию которой будет определять GravityCompat
				drawerL.openDrawer(GravityCompat.START)
				// что бы закрыть gravity
				// drawerL.closeDrawer(GravityCompat.START)
			}
		}
	}
}