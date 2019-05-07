package com.example.manechoiceapp
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE $TABLE_NAME " +
                "(ID INTEGER UNIQUE DEFAULT(1), " +
                "HAIR_TYPE TEXT, " +
                "HAIR_PATTERN TEXT, " +
                "HAIR_TEXTURE TEXT, " +
                "HAIR_LENGTH TEXT, " +
                "HAIR_ABSORBENT TEXT, " +
                "HAIR_FULLNESS TEXT, " +
                "Constraint singleRow CHECK (ID = 1))")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertData(hairtype: String, hairpattern: String, hairtexture: String, hairabsorbent: String, hairfullness: String, hairlength: String){
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, hairtype)
        contentValues.put(COL_3, hairpattern)
        contentValues.put(COL_4, hairtexture)
        contentValues.put(COL_5, hairabsorbent)
        contentValues.put(COL_6, hairfullness)
        contentValues.put(COL_7, hairlength)

        db.insert(TABLE_NAME, null, contentValues)

    }

    fun updateData1(id: String, hairtype: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, hairtype)
        db.update(TABLE_NAME, contentValues, "ID = ?", arrayOf(id))

    }
    fun updateData2(id: String, hairpattern: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_3, hairpattern)
        db.update(TABLE_NAME, contentValues, "ID = ?", arrayOf(id))

    }
    fun updateData3(id: String, hairtexture: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_4, hairtexture)
        db.update(TABLE_NAME, contentValues, "ID = ?", arrayOf(id))

    }
    fun updateData4(id: String, hairlength: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_5, hairlength)
        db.update(TABLE_NAME, contentValues, "ID = ?", arrayOf(id))

    }
    fun updateData5(id: String, hairabsorbent: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_6, hairabsorbent)
        db.update(TABLE_NAME, contentValues, "ID = ?", arrayOf(id))

    }
    fun updateData6(id: String, hairfullness: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_7, hairfullness)
        db.update(TABLE_NAME, contentValues, "ID = ?", arrayOf(id))
    }

    fun deleteData(){
        val db = this.writableDatabase
        db.execSQL("DELETE FROM $TABLE_NAME")
    }

    val allData : Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
            return res
        }

    companion object {
        val DATABASE_NAME = "hairProduct2.db"
        val TABLE_NAME = "hair_table"
        val COL_1 = "id"
        val COL_2 = "hair_type"
        val COL_3 = "hair_pattern"
        val COL_4 = "hair_texture"
        val COL_5 = "hair_length"
        val COL_6 = "hair_absorbent"
        val COL_7 = "hair_fullness"
    }
}



