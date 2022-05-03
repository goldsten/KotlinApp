package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinapp.databinding.ActivityMainSecondBinding

class MainActivitySecond : AppCompatActivity() {
		private lateinit var binding: ActivityMainSecondBinding


	override fun onCreate(savedInstanceState: Bundle?) {
		binding = ActivityMainSecondBinding.inflate(layoutInflater)
		super.onCreate(savedInstanceState)
		setContentView(binding.root)

		binding.button.setOnClickListener {
			// создаем intent
			val i = Intent()
			// помещяем информацию (ключ, значение)
			i.putExtra(" key", "done")
			// отправляем intent (RESULT_OK, intent)
			setResult(RESULT_OK, i)
			// что бы закончить и вернуться в активити которое вызывало
			finish()
		}
	}




}