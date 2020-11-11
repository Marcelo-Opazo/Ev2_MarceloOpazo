package Clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// es necesario agregar los override se hace con alt enter y despues crear el constructor el cual se selecciona el primero

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //me permite definir la config inicial de la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {                                                                                           //     <---
        // |
        db.execSQL("CREATE TABLE clientes(codigo int primary key, nombre text, salario float)"); //ejecuto sentencia sql a partir del parametro de arriba
    }

    //Me permimte realizar cambios esquematicos en mi modelo.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}


