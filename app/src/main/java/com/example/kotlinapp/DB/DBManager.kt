package com.example.kotlinapp.DB

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
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
	fun readDBData(searchText: String) : ArrayList<ListItem>{
		//то, куда записываем когда считываем
		val dataList = ArrayList<ListItem>()
		// передаем массив с того, что вводит пользователь в поиск
		// % указывает поиск по символу
		val search = arrayOf("%$searchText%")
		// ищем в title
		val selection = "${DBNameClass.TABLE_TITLE} like ?"
		//заполняем
		val cursor = db?.query(DBNameClass.TABLE_NAME, null, selection, search, null, null, null)
		// достаем записаные данные из cursor
		while (cursor?.moveToNext()!!){
			val dataID = cursor.getInt(cursor.getColumnIndexOrThrow(BaseColumns._ID))
			val dataTextTitle = cursor.getString(cursor.getColumnIndexOrThrow(DBNameClass.TABLE_TITLE))
			val dataTextNotes = cursor.getString(cursor.getColumnIndexOrThrow(DBNameClass.TABLE_NOTE))
			val dataTextUri = cursor.getString(cursor.getColumnIndexOrThrow(DBNameClass.TABLE_URI_IMAGE))
			//записываем в массив данные с ...
			val item = ListItem()
			item.id = dataID
			item.title = dataTextTitle
			item.note = dataTextNotes
			item.uri = dataTextUri
			//помещяем в
			dataList.add(item)
		}
		cursor.close()
		return dataList
	}
	// ОБНОВЛЕНИЕ БД
	fun updateDB(id:Int, title: String, note:String, uri: String){
		val selectID = BaseColumns._ID + "=$id"
		val values = ContentValues().apply {
			put(DBNameClass.TABLE_TITLE, title)
			put(DBNameClass.TABLE_NOTE, note)
			put(DBNameClass.TABLE_URI_IMAGE, uri)
		}
		// указываем в какую БД запись
		db?.update(DBNameClass.TABLE_NAME, values, selectID,null)
	}
	// УДАЛЕНИЕ С БД
	fun removeItemFromDB(id: String){
		val selectID = BaseColumns._ID + "=$id"
		// указываем в какую БД запись
		//(в таблице, где ид = ид)
		db?.delete(DBNameClass.TABLE_NAME, selectID, null)
	}
	fun closeDB(){
		dbHelper.close()
	}
}