package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlinapp.databinding.ActivityEditBinding
import com.example.kotlinapp.databinding.ActivityMainBinding

class EditActivity : AppCompatActivity() {
	private lateinit var binding: ActivityEditBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityEditBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.apply {
			fbAddImag.setOnClickListener {
				imageLayout.visibility = View.VISIBLE
				fbAddImag.visibility = View.GONE
			}
			btnDeleteImage.setOnClickListener {
				imageLayout.visibility = View.GONE
				fbAddImag.visibility = View.VISIBLE
			}
		}
	}
}