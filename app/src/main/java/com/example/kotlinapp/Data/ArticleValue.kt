package com.example.kotlinapp.Data

import com.google.gson.annotations.SerializedName

data class ArticleList(
	val
	results: List<Result>,
)
data class Result (
	val url: String,
	val title: String,
	val subsection: String,
	val abstract: String,
	val published_date: String,
	val media: List<Media>,
)
data class Media (
	val caption: String,
	@SerializedName("media-metadata")
	val mediametadata: List<ImageUrl>,
)
data class ImageUrl(
	val url: String,
)
