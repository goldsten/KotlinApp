package com.example.kotlinapp.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

// класс который открывает БД
// DBHelper ждет context
class DBManager(context: Context) {
	// иницилизируем
	val dbHelper = DBHelper(context)
	// спомощью этого объекта будем открывать и записывать
	var db: SQLiteDatabase? = null

	// ОТКРЫТИЕ БД
	fun openDB(){
		//открываем БД для записи writableDatabase
		db = dbHelper.writableDatabase
	}
	//ЗАПИСЬ в БД
	fun isertToDB(title: String, description:String){
		//значения которые передаются в БД
		val values = ContentValues().apply {
			// put(key: Type, velues: Type)
			put(DBNameClass.TABLE_TITLE, title)
			put(DBNameClass.TABLE_DESCRIPTION, description)
		}
		// указываем в какую БД запись
		db?.insert(DBNameClass.TABLE_NAME, null, values)
	}
	// СЧИТЫВАНИЕ с БД
	fun readDBData() : ArrayList<String>{
		val dataList = ArrayList<String>()
		//заполняем
		val cursor = db?.query(DBNameClass.TABLE_NAME, null, null, null, null, null, null)
		// достаем записаные данные из cursor
		while (cursor?.moveToNext()!!){
			val dataTextTitle = cursor.getString(cursor.getColumnIndexOrThrow(DBNameClass.TABLE_TITLE))
			//помещяем в
			dataList.add(dataTextTitle.toString())

			val dataTextDesc = cursor.getString(cursor.getColumnIndexOrThrow(DBNameClass.TABLE_DESCRIPTION))
			//помещяем в
			dataList.add(dataTextDesc.toString())
		}
		cursor.close()
		return dataList
	}
	fun closeDB(){
		dbHelper.close()
	}
}