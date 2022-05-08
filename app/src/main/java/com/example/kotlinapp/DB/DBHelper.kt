package com.example.kotlinapp.DB

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// который создает БД
// Context для открытия бд
// SQLiteOpenHelper интерфейс который предоставляет доступ к бд
class DBHelper(context: Context) : SQLiteOpenHelper(context, DBNameClass.DATABASE_NAME, null, DBNameClass.DATABASE_VERSION) {

	// создание таблицы
	override fun onCreate(db: SQLiteDatabase?) {
		db?.execSQL(DBNameClass.CREATE_TABLE)
	}

	// обновление таблицы
	// что бы обновить данные, версию БД нужно менять
	override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
		// удаляем
		db?.execSQL(DBNameClass.DELETE_TABLE)
		// создаем/перезаписываем
		onCreate(db)
	}
}