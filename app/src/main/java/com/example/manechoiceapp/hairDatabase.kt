package com.example.manechoiceapp
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.manechoiceapp.models.Answers

object hairContract {
    // Table contents are grouped together in an anonymous object.
    object hairEntry : BaseColumns {
        const val TABLE_NAME = "hair"
        const val COLUMN_NAME_HAIRTYPE = "hair_type"
        const val COLUMN_NAME_CURLPATTERN = "curl_pattern"
        const val COLUMN_NAME_HAIRTEXTURE = "hair_texture"
        const val COLUMN_NAME_HAIRLENGTH = "hair_length"
        const val COLUMN_NAME_ABSORBANT = "absorbent"
        const val COLUMN_NAME_FULLNESS = "fullness"
    }
}

    interface IDatabase{
        fun addAnswer(answers: Answers)
        fun getAnswers() : List<Answers>
        fun getAnswer(id:Int) :Answers?
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

    class hairDatabase(ctx: Context) :IDatabase{


        override fun addAnswer(answers: Answers) {
            val cvs = toContentValues(answers)
            db.insert(hairContract.hairEntry.TABLE_NAME,null, cvs)
        }

        override fun getAnswers(): List<Answers> {
            val projection = arrayOf(BaseColumns._ID, hairContract.hairEntry.COLUMN_NAME_HAIRTYPE,
                hairContract.hairEntry.COLUMN_NAME_CURLPATTERN,
                hairContract.hairEntry.COLUMN_NAME_HAIRTEXTURE,
                hairContract.hairEntry.COLUMN_NAME_HAIRLENGTH,
                hairContract.hairEntry.COLUMN_NAME_ABSORBANT,
                hairContract.hairEntry.COLUMN_NAME_FULLNESS)

            val sortOrder = "${BaseColumns._ID} ASC"

            val selection = "delete = ?"
            val selectionArgs = arrayOf("0")

            val cursor = db.query(
                hairContract.hairEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder

            )

            val answers = mutableListOf<Answers>()

            with(cursor){
                while (cursor.moveToNext()){
                    val id = getInt(getColumnIndex(BaseColumns._ID))
                    val hair_type = getString(getColumnIndex(hairContract.hairEntry.COLUMN_NAME_HAIRTYPE))
                    val curl_pattern = getString(getColumnIndex(hairContract.hairEntry.COLUMN_NAME_CURLPATTERN))
                    val hair_texture = getString(getColumnIndex(hairContract.hairEntry.COLUMN_NAME_HAIRTEXTURE))
                    val hair_length = getString(getColumnIndex(hairContract.hairEntry.COLUMN_NAME_HAIRLENGTH))
                    val absorbent = getString(getColumnIndex(hairContract.hairEntry.COLUMN_NAME_ABSORBANT))
                    val fullness = getString(getColumnIndex(hairContract.hairEntry.COLUMN_NAME_FULLNESS))

                    val answer = Answers(id, hair_type, curl_pattern, hair_texture, absorbent, hair_length, fullness)
                    answers.add(answer)
                }
            }
            return answers
        }
        override fun getAnswer(id: Int): Answers? {
            val projection = arrayOf(BaseColumns._ID, hairContract.hairEntry.COLUMN_NAME_HAIRTYPE,
                hairContract.hairEntry.COLUMN_NAME_CURLPATTERN,
                hairContract.hairEntry.COLUMN_NAME_HAIRTEXTURE,
                hairContract.hairEntry.COLUMN_NAME_HAIRLENGTH,
                hairContract.hairEntry.COLUMN_NAME_ABSORBANT,
                hairContract.hairEntry.COLUMN_NAME_FULLNESS)

            val selection = "${BaseColumns._ID} = ?"
            val selectionArgs= arrayOf(id.toString())
            val cursor = db.query(
                hairContract.hairEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
            )
            with(cursor){
                cursor.moveToNext()
                    val id = getInt(getColumnIndex(BaseColumns._ID))
                    val hair_type = getString(getColumnIndex(hairContract.hairEntry.COLUMN_NAME_HAIRTYPE))
                    val curl_pattern = getString(getColumnIndex(hairContract.hairEntry.COLUMN_NAME_CURLPATTERN))
                    val hair_texture = getString(getColumnIndex(hairContract.hairEntry.COLUMN_NAME_HAIRTEXTURE))
                    val hair_length = getString(getColumnIndex(hairContract.hairEntry.COLUMN_NAME_HAIRLENGTH))
                    val absorbent = getString(getColumnIndex(hairContract.hairEntry.COLUMN_NAME_ABSORBANT))
                    val fullness = getString(getColumnIndex(hairContract.hairEntry.COLUMN_NAME_FULLNESS))

                    return Answers(id, hair_type, curl_pattern, hair_texture, absorbent, hair_length, fullness)
            }
        }

        override fun deleteAnswer(answers: Answers) {
            val cvs = ContentValues()
            cvs.put("deleted", "1")
            val selection = "${BaseColumns._ID} = ?"
            val selectionArgs = arrayOf(answers.id.toString())
            db.update(hairContract.hairEntry.TABLE_NAME, cvs, selection,selectionArgs)
        }

        override fun updateAnswer(answers: Answers) {
            val cvs = toContentValues(answers)
            val selection = "${BaseColumns._ID} = ?"
            val selectionArgs = arrayOf(answers.id.toString())
            db.update(hairContract.hairEntry.TABLE_NAME, cvs, selection,selectionArgs)
        }


        private fun toContentValues(answers: Answers):ContentValues{
            val cv = ContentValues()
            cv.put(hairContract.hairEntry.COLUMN_NAME_HAIRTYPE, answers.hair_type)
            cv.put(hairContract.hairEntry.COLUMN_NAME_CURLPATTERN, answers.curl_pattern)
            cv.put(hairContract.hairEntry.COLUMN_NAME_HAIRLENGTH, answers.hair_length)
            cv.put(hairContract.hairEntry.COLUMN_NAME_ABSORBANT, answers.absorbent)
            cv.put(hairContract.hairEntry.COLUMN_NAME_HAIRLENGTH, answers.hair_length)
            cv.put(hairContract.hairEntry.COLUMN_NAME_FULLNESS, answers.fullness)

            return cv

        }

        private val db: SQLiteDatabase

        init {
            db = hairDBHelper(ctx).writableDatabase
        }
        class hairDBHelper (ctx: Context): SQLiteOpenHelper(ctx, DATABASE_NAME, null, DATABASE_VERSION){
            override fun onCreate(db: SQLiteDatabase?) {
                db?.execSQL(SQL_CREATE_ENTRIES)
            }

            override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
                db?.execSQL(SQL_DELETE_ENTRIES)
                onCreate(db)
            }


            companion object {
                val DATABASE_NAME = "hair.db"
                val DATABASE_VERSION = 1
            }

        }


    }




}