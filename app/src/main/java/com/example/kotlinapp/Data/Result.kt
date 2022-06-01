package com.example.kotlinapp.Data

data class Result (
	val url: String,
	val title: String,
	val subsection: String,
	val abstract: String,
	val published_date: String,
	val media: List<Media>,

)