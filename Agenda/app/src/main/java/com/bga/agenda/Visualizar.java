package com.bga.agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bga.agenda.Evento;

public class Visualizar extends Activity {

    private String[] tiposeventos = new String[]{"Saude", "Familia", "Escola", "Trabalho", "Lazer"};
    private String[] repeticao = new String[]{"Anualmente", "Mensalmente", "Semanalmente", "Diariamente"};


    private Evento evento = new Evento();
    private TextView nome_evento;
    private TextView tiposelecionado;
    private TextView data_evento;
    private TextView hora_inicio;
    private TextView hora_termino;
    private TextView local_evento;
    private TextView participantes;
    private TextView repetir_txt;
    private TextView repetir_evento;
    private TextView descricao_evento;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizar);

        nome_evento = (TextView) findViewById(R.id.nome);
        tiposelecionado = (TextView) findViewById(R.id.tiposelecionado);
        data_evento = (TextView) findViewById(R.id.data);
        hora_inicio = (TextView) findViewById(R.id.horainicio);
        hora_termino = (TextView) findViewById(R.id.horatermino);
        local_evento = (TextView) findViewById(R.id.local);
        participantes = (TextView) findViewById(R.id.participantes);
        repetir_txt = (TextView) findViewById(R.id.repetirtxt);
        repetir_evento = (TextView) findViewById(R.id.repetir);
        descricao_evento = (TextView) findViewById(R.id.descricao);


        Intent intent = getIntent();
        if (intent != null)

        {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {

                evento.setId(bundle.getLong("id"));
                evento.setNome(bundle.getString("nome"));
                evento.setTiposelecionado(bundle.getString("tipos"));
                evento.setData(bundle.getString("data"));
                evento.setHorainicio(bundle.getString("horainicio"));
                evento.setHoratermino(bundle.getString("hora termino"));
                evento.setLocal(bundle.getString("local"));
                evento.setParticipantes(bundle.getString("participantes"));
                evento.setRepetirtxt(bundle.getString("repeticao"));
                evento.setRepetir(bundle.getString("repetir"));
                evento.setDescricao(bundle.getString("descricao"));


                nome_evento.setText(evento.getNome());
                tiposelecionado.setText(evento.getTiposelecionado());
                data_evento.setText(evento.getData());
                hora_inicio.setText(evento.getHorainicio());
                hora_termino.setText(evento.getHoratermino());
                local_evento.setText(evento.getLocal());
                participantes.setText(evento.getParticipantes());
                repetir_txt.setText(evento.getRepetirtxt());
                repetir_evento.setText(evento.getRepetir());
                descricao_evento.setText(evento.getDescricao());
            }
        }
    }

    public void visualizar(View view){
        evento.setNome(nome_evento.getText().toString());
        evento.setTiposelecionado(tiposelecionado.getText().toString());
        evento.setData(data_evento.getText().toString());
        evento.setHorainicio(hora_inicio.getText().toString());
        evento.setHoratermino(hora_termino.getText().toString());
        evento.setLocal(local_evento.getText().toString());
        evento.setParticipantes(participantes.getText().toString());
        evento.setRepetirtxt(repetir_txt.getText().toString());
        evento.setRepetir(repetir_evento.getText().toString());
        evento.setDescricao(descricao_evento.getText().toString());

        BD bd = new BD(this);
        bd.atualizar(evento);

        //Toast.makeText(this, "Evento \"" + evento.getNome() + "\" atuailizado com sucesso.", Toast.LENGTH_SHORT).show();
    }


}
