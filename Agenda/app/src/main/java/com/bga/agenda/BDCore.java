package com.bga.agenda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDCore extends SQLiteOpenHelper {
    private SQLiteDatabase bd;
    Context context;
    private static final String NOME_BD = "BancoAgenda";
    private static final int VERSAO_BD = 19;


    public BDCore(Context ctx){
        super(ctx, NOME_BD, null, VERSAO_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table evento(_id integer primary key autoincrement, nome text not null, tipos text not null, data text not null, horainicio time not null, horatermino time not null, local text not null, participantes text not null, repeticao text not null, repetir integer not null, descricao text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("drop table evento;");
        onCreate(bd);
    }

}
