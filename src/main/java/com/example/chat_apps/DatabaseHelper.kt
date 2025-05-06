package com.example.chat_apps

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $COL_1 INTEGER PRIMARY KEY AUTOINCREMENT, 
                $COL_2 TEXT, 
                $COL_3 TEXT, 
                $COL_4 TEXT, 
                $COL_5 TEXT
            )
        """
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertUser(username: String, password: String, phone: String, country: String): Boolean {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(COL_2, username)
            put(COL_3, password)
            put(COL_4, phone)
            put(COL_5, country)
        }
        val result = db.insert(TABLE_NAME, null, contentValues)
        return result != -1L
    }

    fun checkUser(username: String, password: String): Boolean {
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COL_2=? AND $COL_3=?"
        val cursor = db.rawQuery(query, arrayOf(username, password))
        return cursor.count > 0
    }

    companion object {
        private const val DATABASE_NAME = "ChatApp.db"
        private const val TABLE_NAME = "users"
        private const val COL_1 = "ID"
        private const val COL_2 = "USERNAME"
        private const val COL_3 = "PASSWORD"
        private const val COL_4 = "PHONE"
        private const val COL_5 = "COUNTRY"
    }
}
