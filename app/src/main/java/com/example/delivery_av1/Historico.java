package com.example.delivery_av1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class Historico extends AppCompatActivity {

    private ListView listView;
    private PedidoDAO dao;
    private List<Pedido> pedidos;
    private List<Pedido> pedidosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        listView = findViewById(R.id.lista_historico);
        dao = new PedidoDAO(this);
        //pedidos = dao.obterTodos();
        pedidosFiltrados.addAll(pedidos);
        ArrayAdapter<Pedido> adaptador = new ArrayAdapter<Pedido>(this,android.R.layout.simple_list_item_1,pedidos);
        listView.setAdapter(adaptador);

    }
}
