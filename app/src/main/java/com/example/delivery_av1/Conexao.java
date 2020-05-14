package com.example.delivery_av1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {
    public Conexao(@Nullable Context context, String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Delivery.db", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table pedidos (id integer primary key autoincrement, produto varchar(50), acomp1 varchar(15),valor varchar(15),quantidade varchar(15), total varchar(15), obs varchar(15))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void solicitarPedido(String produto, String acomp1, String valor, String quantidade, String total, String obs) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("produto", produto);
        dados.put("acomp1", acomp1);
        dados.put("valor", valor);
        dados.put("quantidade", quantidade);
        dados.put("total", total);
        dados.put("obs", obs);
        db.insert("pedidos", null, dados);
    }

    public Cursor getDados() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from pedidos", null);
    }
}
