package com.bga.agenda;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Cadastro extends Activity {
    private Evento evento = new Evento();
    private EditText nome_evento;
    private EditText data_evento;
    private EditText hora_inicio;
    private EditText hora_termino;
    private EditText local_evento;
    private EditText participantes;
    private Button salvarBt;
    private Button editarBt;
    private EditText repetir_evento;
    private EditText descricao_evento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        nome_evento = (EditText) findViewById(R.id.nome);
        data_evento = (EditText) findViewById(R.id.data);
        hora_inicio = (EditText) findViewById(R.id.horainicio);
        hora_termino = (EditText) findViewById(R.id.horatermino);
        local_evento = (EditText) findViewById(R.id.local);
        participantes = (EditText) findViewById(R.id.participantes);
        repetir_evento = (EditText) findViewById(R.id.repetir);
        descricao_evento = (EditText) findViewById(R.id.descricao);


        salvarBt = (Button) findViewById(R.id.button1);
        editarBt = (Button) findViewById(R.id.button2);


        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){

                evento.setId(bundle.getLong("id"));
                evento.setNome(bundle.getString("nome"));
                evento.setData(bundle.getString("data"));
                evento.setHorainicio(bundle.getString("horainicio"));
                evento.setHoratermino(bundle.getString("hora termino"));
                evento.setLocal(bundle.getString("local"));
                evento.setParticipantes(bundle.getString("participantes"));
                evento.setRepetir(bundle.getString("repetir"));
                evento.setDescricao(bundle.getString("descricao"));


                nome_evento.setText(evento.getNome());
                data_evento.setText(evento.getData());
                hora_inicio.setText(evento.getHorainicio());
                hora_termino.setText(evento.getHoratermino());
                local_evento.setText(evento.getLocal());
                participantes.setText(evento.getParticipantes());
                repetir_evento.setText(evento.getRepetir());
                descricao_evento.setText(evento.getDescricao());

                salvarBt.setVisibility(View.GONE);
                editarBt.setVisibility(View.VISIBLE);
            }
        }
    }


    public void salvarEvento(View view){
        evento.setNome(nome_evento.getText().toString());
        evento.setData(data_evento.getText().toString());
        evento.setHorainicio(hora_inicio.getText().toString());
        evento.setHoratermino(hora_termino.getText().toString());
        evento.setLocal(local_evento.getText().toString());
        evento.setParticipantes(participantes.getText().toString());
        evento.setRepetir(repetir_evento.getText().toString());
        evento.setDescricao(descricao_evento.getText().toString());

        BD bd = new BD(this);
        bd.inserir(evento);

        Toast.makeText(this, "Evento inserido com sucesso!", Toast.LENGTH_SHORT).show();
    }


    public void editarEvento(View view){
        evento.setNome(nome_evento.getText().toString());
        evento.setData(data_evento.getText().toString());
        evento.setHorainicio(hora_inicio.getText().toString());
        evento.setHoratermino(hora_termino.getText().toString());
        evento.setLocal(local_evento.getText().toString());
        evento.setParticipantes(participantes.getText().toString());
        evento.setRepetir(repetir_evento.getText().toString());
        evento.setDescricao(descricao_evento.getText().toString());

        BD bd = new BD(this);
        bd.atualizar(evento);

        Toast.makeText(this, "Evento \""+evento.getNome()+"\" atuailizado com sucesso.", Toast.LENGTH_SHORT).show();
    }

}
