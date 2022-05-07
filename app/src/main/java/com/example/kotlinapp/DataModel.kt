package com.example.kotlinapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
	// что бы не создавать каждый раз новое, by lazy будет брать уже созданную новую инстанцию
	// LiveData обновляется в нужный момент
	// разделяем кнопки
	val messageActivity: MutableLiveData<String> by lazy {
		MutableLiveData<String>()
	}
	val messageFragment1: MutableLiveData<String> by lazy {
		MutableLiveData<String>()
	}
	val messageFragment2: MutableLiveData<String> by lazy {
		MutableLiveData<String>()
	}
}