package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
	private lateinit var binding: ActivityMain2Binding

	override fun onCreate(s: Bundle?) {
		super.onCreate(s)
		binding = ActivityMain2Binding.inflate(layoutInflater)
		setContentView(binding.root)
	}
}