package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapp.DB.DBManager
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	// создаем менеджер БД (context)
	val managerDB = DBManager(this)
	// передаем context
	val Adapter = rcAdapter(ArrayList(), this)

	override fun onCreate(s: Bundle?) {
		super.onCreate(s)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		binding.fbNew.setOnClickListener {
			// создаем переход в editActivity
			val i = Intent(this, EditActivity::class.java)
			startActivity(i)
		}

		init()
	}

	override fun onResume() {
		super.onResume()
		managerDB.openDB()
		init()

		fillAdapter()
	}

	override fun onDestroy() {
		super.onDestroy()
		managerDB.closeDB()
	}
	// инициализация адаптера
	fun init(){
		// if (){}
		// LinearLayoutManager(this) - элементы будут распологаться по вертикали
		binding.rcView.layoutManager = LinearLayoutManager(this)
		binding.rcView.adapter = Adapter
	}
	//
	fun fillAdapter(){
		// считываем с БД, передаем в Adapter и обновляем список
		Adapter.updateAdapter(managerDB.readDBData())
	}
}