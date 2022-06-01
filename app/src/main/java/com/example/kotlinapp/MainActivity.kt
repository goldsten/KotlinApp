package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlinapp.Interface.ArticleApi
import com.example.kotlinapp.RetrofitHelper.RetrofitHelper
import com.example.kotlinapp.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding

	override fun onCreate(s: Bundle?) {
		binding = ActivityMainBinding.inflate(layoutInflater)
		super.onCreate(s)
		setContentView(binding.root)

		val articleApi = RetrofitHelper.getInstance().create(ArticleApi::class.java)
		// launching a new coroutine
		GlobalScope.launch {
			val result = articleApi.getArticle()
			Log.d("TAG", result.body().toString())
		}
	}
}