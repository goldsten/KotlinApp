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
	// ArrayList<listItem> то что мы возвращаем когда считываем БД
	fun readDBData() : ArrayList<ListItem>{
		//то, куда записываем когда считываем
		val dataList = ArrayList<ListItem>()
		//заполняем
		val cursor = db?.query(DBNameClass.TABLE_NAME, null, null, null, null, null, null)
		// достаем записаные данные из cursor
		while (cursor?.moveToNext()!!){
			val dataTextTitle = cursor.getString(cursor.getColumnIndexOrThrow(DBNameClass.TABLE_TITLE)).toString()
			val dataTextNotes = cursor.getString(cursor.getColumnIndexOrThrow(DBNameClass.TABLE_NOTE)).toString()
			val dataTextUri = cursor.getString(cursor.getColumnIndexOrThrow(DBNameClass.TABLE_URI_IMAGE)).toString()
			//записываем в массив данные с ...
			val item = ListItem()
			item.title = dataTextTitle
			item.note = dataTextNotes
			item.uri = dataTextUri
			//помещяем в
			dataList.add(item)
		}
		cursor.close()
		return dataList
	}
	fun closeDB(){
		dbHelper.close()
	}
}