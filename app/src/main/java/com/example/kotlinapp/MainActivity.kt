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
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	fun Message(text: String){Toast.makeText(this, text, Toast.LENGTH_SHORT).show()}

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)
		binding.apply {
			// default Fragment
			supportFragmentManager.beginTransaction().replace(R.id.main_container, FragmentItemFirst.newInstance()).commit()

			bottomBar.setOnItemSelectedListener { item ->
				when(item.itemId) {
					R.id.shop -> {
						supportFragmentManager.beginTransaction().replace(R.id.main_container, FragmentItemFirst.newInstance()).commit()
						true
					}
					R.id.category -> {
						supportFragmentManager.beginTransaction().replace(R.id.main_container, FragmentItemSecond.newInstance()).commit()
						true
					}
					R.id.follow -> {
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

			topBar.setNavigationOnClickListener  {
				val intent = Intent(this@MainActivity, MainActivity2::class.java)
				startActivity(intent)
			}

		} // END BINDING
	} // END onCreate
} // END CLASS