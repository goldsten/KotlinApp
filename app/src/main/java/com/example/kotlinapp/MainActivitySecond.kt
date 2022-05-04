package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinapp.databinding.ActivityMainSecondBinding

class MainActivitySecond : AppCompatActivity() {
	private lateinit var binding: ActivityMainSecondBinding

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainSecondBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)

		binding.button2.setOnClickListener{
			val edView = binding.edView.text.toString()
			//
			if (edView != ""){
				val i = Intent()
				i.putExtra("key", "ActivitySecond: $edView")
				setResult(RESULT_OK, i)
				// закрываем активити
				finish()
			}else	binding.erView.text = "Empty field"

		}
	}
}