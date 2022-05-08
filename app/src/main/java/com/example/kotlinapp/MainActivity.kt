package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.kotlinapp.DB.DBManager
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	// создаем менеджер (context)
	val managerDB = DBManager(this)

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)

		binding.btnSave.setOnClickListener {
			binding.apply {
				val title = edTitle.text.toString()
				val desc = edDesc.text.toString()
				if (!title.isEmpty() && !desc.isEmpty()){
					if (!title.isEmpty() && !desc.isEmpty()){
						// при каджом нажатии, текст нужно обновлять, иначе будет добавляться и добавляться
						tvResult.text = ""
						managerDB.openDB()
						managerDB.isertToDB(title, desc)
						// считываем данные с БД и выводим
						// readDBData() возвращает массив данных
						val dataList = managerDB.readDBData()
						for (item in dataList){
							// append() добавлять к уже имеющимся
							tvResult.append(item).toString()
							Log.d( "TAG", "$item")
							tvResult.append("\n")
						}
					} else {
						tvError.visibility = View.VISIBLE
						tvError.text = "Поля пустые"
					}
				}
			}
		}
	}

	override fun onResume() {
		super.onResume()
		binding.apply {
			managerDB.openDB()
			val dataList = managerDB.readDBData()
			for (item in dataList) {
				// append() добавлять к уже имеющимся
				tvResult.append(item).toString()
				Log.d("TAG", "$item")
				tvResult.append("\n")
			}
		}
	}

	override fun onDestroy() {
		super.onDestroy()
		managerDB.closeDB()
	}
}