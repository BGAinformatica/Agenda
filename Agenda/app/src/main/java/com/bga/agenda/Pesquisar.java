package com.bga.agenda;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Lauro on 08/06/2016.
 */
public class Pesquisar extends Activity{

    private BD manager;
    Cursor cursor;
    ListView listae;
    SimpleCursorAdapter adapter;
    EditText txtvpesquisa;
    SQLiteDatabase bd;
    private Context context;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pesquisar);

        txtvpesquisa = (EditText) findViewById(R.id.txtvpesquisar);
        txtvpesquisa.addTextChangedListener(Mask.insert("##/##/####", txtvpesquisa));

        manager = new BD(this);
        listae = (ListView) findViewById(R.id.listae);


        manager = new BD(getBaseContext());

        String[] from = new String[]{"nome", "data"};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};
        cursor = manager.mostrarevento();
        adapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, cursor, from, to);
        listae.setAdapter(adapter);

        listae.setOnItemClickListener(seleciona());


    }

    public AdapterView.OnItemClickListener seleciona(){

        return(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Click ListItem Number " + position, Toast.LENGTH_LONG).show();


            }
        });
    }

    public void btnpesquisar(View view) {


        listae.setVisibility(View.VISIBLE);

      /*  bd.execSQL("delete from evento where data = ?",
                new String[]{txtvpesquisa.getText().toString()});*/

        Cursor c = manager.pesquisarevento(txtvpesquisa.getText().toString());
        adapter.changeCursor(c);


    }

   public void btnapagar(View view){

       String[] colunas = new String[]{"_id", "nome", "tipos", "data", "horainicio", "horatermino", "local", "participantes", "repeticao", "repetir", "descricao"};

       Cursor c = manager.deleteevento(txtvpesquisa.getText().toString());
       adapter.changeCursor(c);

    }


}