package com.example.manechoiceapp
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.manechoiceapp.models.Answers

object hairContract{
    // Table contents are grouped together in an anonymous object.
    object hairEntry : BaseColumns{
        const val TABLE_NAME = "hair"
        const val COLUMN_NAME_HAIRTYPE= "hair_type"
        const val COLUMN_NAME_CURLPATTERN= "curl_pattern"
        const val COLUMN_NAME_HAIRTEXTURE= "hair_texture"
        const val COLUMN_NAME_HAIRLENGTH= "hair_length"
        const val COLUMN_NAME_ABSORBANT= "absorbent"
        const val COLUMN_NAME_FULLNESS= "fullness"
    }

    interface IDatabase{
        fun addAnswer(answers: Answers)
        fun getAnswers() : List<Answers>
        fun deleteAnswer(answers: Answers)
        fun updateAnswer(answers: Answers)

    }

    private const val SQL_CREATE_ENTRIES = "CREATE TABLE ${hairContract.hairEntry.TABLE_NAME} (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, " +
            "${hairContract.hairEntry.COLUMN_NAME_HAIRTYPE} TEXT, "+
            "${hairContract.hairEntry.COLUMN_NAME_CURLPATTERN} TEXT, "+
            "${hairContract.hairEntry.COLUMN_NAME_HAIRTEXTURE} TEXT, "+
            "${hairContract.hairEntry.COLUMN_NAME_HAIRLENGTH} TEXT, "+
            "${hairContract.hairEntry.COLUMN_NAME_ABSORBANT} TEXT, "+
            "${hairContract.hairEntry.COLUMN_NAME_FULLNESS} TEXT, "+
            ")"
    private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${hairContract.hairEntry.TABLE_NAME}"



}