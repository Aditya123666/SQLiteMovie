package camp.bso.inf.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

/**
 * Created by MUL17 on 2/7/2018.
 */

public class SQLiteHelper extends SQLiteOpenHelper{



    //
    public SQLiteHelper(Context context , String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }

    public void queryData(String sql){
        try (SQLiteDatabase database = getWritableDatabase()) {
            database.execSQL(sql);
        }
    }

    public void insertData(String name,String asal,byte[]image){
        SQLiteDatabase database = getWritableDatabase();

        String sql = "INSERT INTO FOOD VALUES (NULL,?,?,?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,name);
        statement.bindString(2,asal);
        statement.bindBlob(3,image);

        statement.executeInsert();
    }
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}