package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinapp.databinding.ActivityMainSecondBinding

class MainActivitySecond : AppCompatActivity() {
	private lateinit var binding: ActivityMainSecondBinding

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainSecondBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)


	}
}