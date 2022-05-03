package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	private var launcher: ActivityResultLauncher<Intent>? = null

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)
		launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
			result: ActivityResult ->
			if (result.resultCode == RESULT_OK){
				val txt = result.data?.getStringExtra("key")
				binding.tvResult.text = txt
				Log.d("MyLog", "Result $txt")
			}
		}

		binding.button1.setOnClickListener{
			launcher?.launch(Intent(this, MainActivitySecond::class.java))
		}
	}


}