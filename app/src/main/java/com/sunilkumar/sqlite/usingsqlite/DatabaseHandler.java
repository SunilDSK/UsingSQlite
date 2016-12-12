package com.sunilkumar.sqlite.usingsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Sunilkumar on 12-12-2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "studentInfo";

    // Contacts table name
    private static final String STUDENT = "student";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    private static final String KEY_CGPA = "cgpa";

    //This will create the database
    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }

    //This will create the table in the database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE "+ STUDENT + "("
                +KEY_ID+" INTEGER PRIMARY KEY,"+ KEY_NAME+" TEXT,"
                +KEY_AGE+" INTEGER, "+KEY_CGPA+" REAL);";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }


    //This will delete the old database and create a new database
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + STUDENT);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

    /**
     * Among all CRUD(Create, Read, Update, Delete) Operations
     * here we will implement only the create and read operation
     */

    void addStudent(Student student){
        //SQLite instance using which we can write in DB
        SQLiteDatabase db = this.getWritableDatabase();

        //Create a bundle of the values
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,student.getName());
        values.put(KEY_AGE,student.getAge());
        values.put(KEY_CGPA,student.getCgpa());

        //Insert the values in the student table
        db.insert(STUDENT,null,values);
        //Terminate the connection
        db.close();
    }

    void readStudent(){
        //Sqlite instance using which we can read the content of DB
        SQLiteDatabase db = this.getReadableDatabase();
        //Create the SQL query
        String query = "SELECT * FROM STUDENT";
        //Execute the SQL query
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            Log.i("STUDENT Table","below is the content of table");
            do{
                Log.i("KEY_ID",String.valueOf(cursor.getInt(0)));
                Log.i("KEY_Name",cursor.getString(1));
                Log.i("KEY_ID",String.valueOf(cursor.getInt(2)));
                Log.i("KEY_ID",String.valueOf(cursor.getFloat(3)));
            }while (cursor.moveToNext());
        }
    }
}
