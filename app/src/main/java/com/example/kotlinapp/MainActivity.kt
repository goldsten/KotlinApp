package com.example.kotlinapp

import android.content.Intent
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

		binding.fbNew.setOnClickListener {
			// создаем переход в editActivity
			val i = Intent(this, EditActivity::class.java)
			startActivity(i)
		}
	}

	override fun onResume() {
		super.onResume()
		binding.apply {
			managerDB.openDB()


		}
	}

	override fun onDestroy() {
		super.onDestroy()
		managerDB.closeDB()
	}
}