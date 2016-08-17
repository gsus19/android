package app.gsusrodbe.com.GsusAPP;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jjrodrig on 08/08/2016.
 */
public class DBpersonas extends SQLiteOpenHelper {


    public DBpersonas(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE Personas (id INTEGER PRIMARY KEY, nombre TEXT, apellido TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS Personas");

        db.execSQL("CREATE TABLE Personas (id INTEGER PRIMARY KEY, nombre TEXT, apellido TEXT)");
    }
}
