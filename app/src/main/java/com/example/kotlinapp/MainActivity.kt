package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(s: Bundle?) {
		super.onCreate(s)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		// открытие sidebar
		binding.apply {
			// слушатель кнопок в navigation menu
			navViewId.setNavigationItemSelectedListener {
				//it это item а itemID id элемента
				when(it.itemId){
					// this@MainActivity - указываем конкретно this (эта функция) и куда передаем MainActivity
					R.id.msg -> Toast.makeText(this@MainActivity, "Message", Toast.LENGTH_SHORT).show()
					R.id.multimedia -> {
						Toast.makeText(this@MainActivity, "Multimedia", Toast.LENGTH_SHORT).show()
					}
					R.id.setting -> {Toast.makeText(this@MainActivity, "Setting", Toast.LENGTH_SHORT).show()}
				}
				// что бы после нажатия закрывать drawer layout
				drawerL.closeDrawer(GravityCompat.START)

				true
			}
			open.setOnClickListener {
				// выбираем кнопку, по нажатию которой будет определять GravityCompat
				drawerL.openDrawer(GravityCompat.START)
				// что бы закрыть gravity
				// drawerL.closeDrawer(GravityCompat.START)
			}
		}
	}
}