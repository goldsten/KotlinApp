package com.example.kotlinapp.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.kotlinapp.ListItem

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
	fun isertToDB(title: String, note:String, uri: String){
		//значения которые передаются в БД
		val values = ContentValues().apply {
			// put(key: Type, velues: Type)
			put(DBNameClass.TABLE_TITLE, title)
			put(DBNameClass.TABLE_NOTE, note)
			put(DBNameClass.TABLE_URI_IMAGE, uri)
		}
		// указываем в какую БД запись
		db?.insert(DBNameClass.TABLE_NAME, null, values)
	}
	// СЧИТЫВАНИЕ с БД
	fun readDBData() : ArrayList<ListItem>{
		val dataList = ArrayList<ListItem>()
		//заполняем
		val cursor = db?.query(DBNameClass.TABLE_NAME, null, null, null, null, null, null)
		// достаем записаные данные из cursor
		while (cursor?.moveToNext()!!){
			val dataTitle = cursor.getString(cursor.getColumnIndexOrThrow(DBNameClass.TABLE_TITLE))
			val dataNote = cursor.getString(cursor.getColumnIndexOrThrow(DBNameClass.TABLE_NOTE))
			val dataUri = cursor.getString(cursor.getColumnIndexOrThrow(DBNameClass.TABLE_URI_IMAGE))
			val list = ListItem()
			list.title = dataTitle
			list.note = dataNote
			list.uri = dataUri
			//помещяем в
			dataList.add(list)


		}
		cursor.close()
		return dataList
	}
	fun closeDB(){
		dbHelper.close()
	}
}