package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	fun Message(text: String){
		return Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
	}

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)


		binding.bottomNavigation.setOnItemSelectedListener { item ->
			when(item.itemId) {
				R.id.shop -> {
					// Respond to navigation item 1 click
					Message("Fragment ${item.itemId}")

					true
				}
				R.id.category -> {
					// Respond to navigation item 2 click
					Message("Fragment ${item.itemId}")
					true
				}
				R.id.profile -> {
					// Respond to navigation item 2 click
					Message("Fragment ${item.itemId}")
					true
				}
				else -> false
			}
		}

	}
}