package com.example.kotlinapp.DB

import android.provider.BaseColumns

// интерфейс BaseColumns
object DBNameClass : BaseColumns {
	// таблица
	const val TABLE_NAME ="sql_table"
	// содержание таблицы
	const val TABLE_TITLE ="title"
	const val TABLE_DESCRIPTION ="description"

	// версия
	const val DATABASE_VERSION = 1
	//
	const val DATABASE_NAME = "MyDB.db"
	// IF NOT EXISTS проверяем если бд уже существует
	const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
			  //id элемента
			  //text тип данных
			  "${BaseColumns._ID} INTEGER PRIMARY KEY," +
			  "$TABLE_TITLE TEXT," +
			  "$TABLE_DESCRIPTION TEXT)"

	// удаление таблицы
	const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"


}