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


		binding.bottomAppBar.setOnMenuItemClickListener { menuItem ->
			when (menuItem.itemId) {
				R.id.search -> {
					// Handle search icon press
					true
				}
				R.id.more -> {
					// Handle more item (inside overflow menu) press
					true
				}
				else -> false
			}
		}
	}
}