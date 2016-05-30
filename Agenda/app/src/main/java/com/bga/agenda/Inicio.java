package com.bga.agenda;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.bga.agenda.R;

public class Inicio extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
    }


    public void getActivity(View view){
        Button bt = (Button) view;
        Intent intent;

        if(bt.getText().toString().equalsIgnoreCase("Novo evento")){
            intent = new Intent(this, Cadastro.class);
        }
        else{
            intent = new Intent(this, Listaevento.class);
        }

        startActivity(intent);
    }

    public void Visualizar(View view){
        startActivity(new Intent(this, Visualizar.class));
    }
}
