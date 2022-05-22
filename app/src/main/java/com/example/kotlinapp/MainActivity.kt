package com.example.kotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlinapp.databinding.ActivityMainBinding
import com.example.kotlinapp.fragments.FragmentItemFirst
import com.example.kotlinapp.fragments.FragmentItemFourth
import com.example.kotlinapp.fragments.FragmentItemSecond
import com.example.kotlinapp.fragments.FragmentItemThird

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	fun Message(text: String){Toast.makeText(this, text, Toast.LENGTH_SHORT).show()}

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)
		binding.apply {
			// default Fragment

			bottomBar.setOnItemSelectedListener { item ->
				when(item.itemId) {
					R.id.home -> {
						supportFragmentManager.beginTransaction().replace(R.id.horizontalScroll1, FragmentItemFirst.newInstance()).commit()
						true
					}
					R.id.booking -> {
						supportFragmentManager.beginTransaction().replace(R.id.main_container, FragmentItemSecond.newInstance()).commit()
						true
					}
					R.id.save -> {
						supportFragmentManager.beginTransaction().replace(R.id.main_container, FragmentItemThird.newInstance()).commit()
						true
					}
					R.id.profile -> {
						supportFragmentManager.beginTransaction().replace(R.id.main_container, FragmentItemFourth.newInstance()).commit()
						true
					}
					else -> false
				}
			}


		} // END BINDING
	} // END onCreate
} // END CLASS