package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)


		binding.btnResult.setOnClickListener {
			if (!isFieldEmpty()) binding.tvResult.text = getResult()
		}
	}

	private fun isFieldEmpty(): Boolean{
		binding.apply {
			if (edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()) edA.error ="Field value"
			return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
		}
	}
	private fun getResult():String{
		val a: Double
		val b: Double
		binding.apply {
			a = edA.text.toString().toDouble()
			b = edB.text.toString().toDouble()
		}
		return sqrt((a.pow(2) + b.pow(2))).toString()
	}
}