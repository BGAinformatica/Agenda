package com.bga.agenda;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BD {
    private SQLiteDatabase bd;

    public BD(Context context){
        BDCore auxBd = new BDCore(context);
        bd = auxBd.getWritableDatabase();
    }


    public void inserir(Evento evento){
        ContentValues valores = new ContentValues();
        valores.put("nome", evento.getNome());
        valores.put("data", evento.getData());
        valores.put("horainicio", evento.getHorainicio());
        valores.put("horatermino", evento.getHoratermino());
        valores.put("local", evento.getLocal());
        valores.put("participantes", evento.getParticipantes());
        valores.put("repetir", evento.getRepetir());
        valores.put("descricao", evento.getDescricao());

        bd.insert("evento", null, valores);
    }


    public void atualizar(Evento evento){
        ContentValues valores = new ContentValues();
        valores.put("nome", evento.getNome());
        valores.put("data", evento.getData());
        valores.put("horainicio", evento.getHorainicio());
        valores.put("horatermino", evento.getHoratermino());
        valores.put("local", evento.getLocal());
        valores.put("participantes", evento.getParticipantes());
        valores.put("repetir", evento.getRepetir());
        valores.put("descricao", evento.getDescricao());

        bd.update("evento", valores, "_id = ?", new String[]{"" + evento.getId()});
    }


    public void deletar(Evento evento){
        bd.delete("evento", "_id = "+evento.getId(), null);
    }


    public List<Evento> buscar(){
        List<Evento> list = new ArrayList<Evento>();
        String[] colunas = new String[]{"_id", "nome", "data", "horainicio", "horatermino", "local", "participantes", "repetir", "descricao"};

        Cursor cursor = bd.query("evento", colunas, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                Evento e = new Evento();
                e.setId(cursor.getLong(0));
                e.setNome(cursor.getString(1));
                e.setData(cursor.getString(2));
                e.setHorainicio(cursor.getString(3));
                e.setHoratermino(cursor.getString(4));
                e.setLocal(cursor.getString(5));
                e.setParticipantes(cursor.getString(6));
                e.setRepetir(cursor.getString(7));
                e.setDescricao(cursor.getString(8));
                list.add(e);

            }while(cursor.moveToNext());
        }

        return(list);
    }
}
