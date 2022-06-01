package com.example.kotlinapp.RetrofitHelper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
	val baseUrl = "https://api.nytimes.com/svc/mostpopular/v2/viewed/"
	fun getInstance(): Retrofit{
		return Retrofit.Builder()
			.baseUrl(baseUrl)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
	}
}