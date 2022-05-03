package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlinapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	private var launcher: ActivityResultLauncher<Intent>? = null

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)

		//создаем callback, регистрируемся на результат с аквтивити
		launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
			// переменная которая создержит возвращаемую информацию
				result: ActivityResult ->
				if (result.resultCode == RESULT_OK){
					// intent
					// если бы мы передавали текст val text = result.data?.getStringExtra("key") - (что бы указать что result.data будет не пустым, нужно дописать result.data? )
					result.data
				}
		}



	}

}