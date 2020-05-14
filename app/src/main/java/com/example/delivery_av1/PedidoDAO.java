package com.example.delivery_av1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public PedidoDAO(Context context) {
//        conexao = new Conexao(context);
//        banco = conexao.getWritableDatabase();
    }

    public long inserir(Pedido pedido) {
        ContentValues values = new ContentValues();
        values.put("produto", pedido.getProduto());
        values.put("acomp1", pedido.getAcomp1());
        values.put("valor", pedido.getValor());
        values.put("quantidade", pedido.getQuantidade());
        values.put("total", pedido.getTotal());
        values.put("obs", pedido.getTotal());
        return banco.insert("pedidos", null, values);
    }

    public void obterTodos() {
        List<Pedido> pedidos = new ArrayList<>();
        Cursor cursor = banco.query("pedidos", new String[]{"id", "produto", "acomp1", "valor", "quantidade", "total", "obs"},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            Pedido a = new Pedido();
            a.setId(cursor.getInt(0));
            a.setProduto(cursor.getString(1));
            a.setAcomp1(cursor.getString(2));
            a.setValor(cursor.getString(3));
            a.setQuantidade(cursor.getString(4));
            a.setTotal(cursor.getString(5));
            a.setObs(cursor.getString(6));
            pedidos.add(a);
        }
            //return pedidos;

        }
    }

