package com.example.kotlinapp.Interface

import com.example.kotlinapp.Data.ArticleList
import retrofit2.Response
import retrofit2.http.GET

const val DAY = 1
const val SEVEN_DAY = 7
const val MONTH = 30
interface ArticleApi {
	@GET("$DAY.json?api-key=2BjBAskB0jaWwHTkDHeJLsXqf1SSgvsS")
	suspend fun getArticle() : Response<ArticleList>
}