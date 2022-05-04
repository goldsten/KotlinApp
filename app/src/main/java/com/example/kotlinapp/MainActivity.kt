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
	//создаем лаунчер <type>
	private var launcher: ActivityResultLauncher<Intent>? = null

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)
		// создаем callback, записываем callback в launcher registerForActivityResult(contract)
		// регистрируем launcher на получение данных с activity2
		launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
			// получаем результат нужно выбирать androidx.activity.result.ActivityResult
			result: ActivityResult ->
			// проверяем если ==
			if (result.resultCode == RESULT_OK){
				// создаем intent, получаем результат
				val txt = result.data?.getStringExtra("key")
				binding.tvResult.visibility = View.VISIBLE
				binding.tvResult.text = txt
				Log.d("MyLog", "Result $txt")
			}
		}

		binding.button1.setOnClickListener{
			// this - с этого activity переходим в MainActivitySecond
			launcher?.launch(Intent(this, MainActivitySecond::class.java))
		}
	}


}