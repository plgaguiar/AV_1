package com.example.delivery_av1;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Conexao mdb;

    private EditText produto;
    private EditText acomp1;
    private EditText valor;
    private EditText quantidade;
    private EditText obs;
    private EditText total;
    private EditText TxValor;
    private EditText TxQuant;
    private EditText TxTotal;
    private PedidoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        produto = findViewById(R.id.TxProduto);
        acomp1 = findViewById(R.id.TxAcomp1);
        valor = findViewById(R.id.TxValor);
        quantidade = findViewById(R.id.TxQuant);
        obs = findViewById(R.id.TxObs);
        total = findViewById(R.id.TxTotal);


        dao = new PedidoDAO(this);

        mdb = new Conexao(this, "Delivery", null, 1);

//        TxValor = (EditText) findViewById(R.id.TxValor);
//        TxQuant = (EditText) findViewById(R.id.TxQuant);
//        TxTotal = (EditText) findViewById(R.id.TxTotal);

        Button btncalc = (Button) findViewById(R.id.btncalc);

        btncalc.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                int number1 = Integer.parseInt(valor.getText().toString());
                int number2 = Integer.parseInt(quantidade.getText().toString());
//                int number1 = Integer.valueOf(valor.getText().toString());
//                int number2 = Integer.valueOf(quantidade.getText().toString());
                int res = number1 * number2;

                TxTotal.setText(String.valueOf(res));
            }
        });

        // Calculo que não funciona nem por reza brava
//        TxValor = (EditText) findViewById(R.id.TxValor);
//        TxQuant = (EditText) findViewById(R.id.TxQuant);
//        TxTotal = (EditText) findViewById(R.id.TxTotal);
//
//        TxValor.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//
//                Calculo();
//            }
//        });
//
//        TxQuant.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//
//                Calculo();
//            }
//        });
//    }
//
//    private void Calculo(){
//
//        double valor1 = Double.parseDouble(TxValor.getText().toString());
//        double valor2 = Double.parseDouble(TxQuant.getText().toString());
//        double resultado =valor1*valor2;

//        double valor1 = Double.parseDouble(TxValor.toString());
//        double valor2 = Double.parseDouble(TxQuant.toString());
//        TxTotal.setText(String.valueOf(valor1 * valor2));
   }

            //Spinner que também não funciona nem com macumba
//        Spinner = (Spinner) findViewById(R.id.Spinner);
//        Spinner com dados sa Strings.xml
//        Spinner spinner =findViewById(R.id.Spinner);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.products, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);

    public void solicitarPedido(View view) {
    //public void solicitarPedido(View v) {

        Pedido a = new Pedido();
        a.setProduto(produto.getText().toString());
        a.setAcomp1(acomp1.getText().toString());
        a.setQuantidade(quantidade.getText().toString());
        a.setValor(valor.getText().toString());
        a.setObs(obs.getText().toString());
        a.setTotal(total.getText().toString());
        long id = dao.inserir(a);


//        String nomeProduto = ((EditText) findViewById(R.id.TxProduto)).getText().toString();
//        String nomeAcomp1 = ((EditText) findViewById(R.id.TxAcomp1)).getText().toString();
//        String nomeTxValor = ((EditText) findViewById(R.id.TxValor)).getText().toString();
//        String nomeTxQuant = ((EditText) findViewById(R.id.TxQuant)).getText().toString();
//        String nomeTxTotal = ((EditText) findViewById(R.id.TxTotal)).getText().toString();
//        String nomeObs = ((EditText) findViewById(R.id.TxObs)).getText().toString();
//        mdb.solicitarPedido(nomeProduto, nomeAcomp1, nomeTxValor, nomeTxQuant, nomeTxTotal, nomeObs);
//        exibirPedido();
//        Toast.makeText(this, "Pedido inserido "+id, Toast.LENGTH_LONG).show();
    }


    public void exibirPedido() {
        ((TextView) findViewById(R.id.txtSelect)).setText("");
        Cursor cursor = mdb.getDados();
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                String id = cursor.getString(0);
                String Produto = cursor.getString(1);
                String Acomp1 = cursor.getString(2);
//                String Acomp2 = cursor.getString(3);
//                String TxTotal = cursor.getString(4);
//                String Obs = cursor.getString(5);

                CharSequence registro = id + ", " + Produto + ", " + Acomp1;
                ((TextView) findViewById(R.id.txtSelect)).append(registro + "\n");
            } while (cursor.moveToNext());
        }
    }
}

