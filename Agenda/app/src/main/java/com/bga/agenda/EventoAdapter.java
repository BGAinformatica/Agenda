package com.bga.agenda;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EventoAdapter extends BaseAdapter {
    private Context context;
    private List<Evento> list;

    public EventoAdapter(Context context, List<Evento> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0).getId();
    }

    @Override
    public View getView(int position, View arg1, ViewGroup arg2) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.evento, null);

        TextView tv = (TextView) layout.findViewById(R.id.nome);
        tv.setText(list.get(position).getNome());


        Button editarBt = (Button) layout.findViewById(R.id.editar);
        editarBt.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, Cadastro.class);
                intent.putExtra("nome", list.get(auxPosition).getNome());
                intent.putExtra("tipos", list.get(auxPosition).getTiposelecionado());
                intent.putExtra("data", list.get(auxPosition).getData());
                intent.putExtra("horainicio", list.get(auxPosition).getHorainicio());
                intent.putExtra("horatermino", list.get(auxPosition).getHoratermino());
                intent.putExtra("local", list.get(auxPosition).getLocal());
                intent.putExtra("participantes", list.get(auxPosition).getParticipantes());
                intent.putExtra("repeticao", list.get(auxPosition).getRepetirtxt());
                intent.putExtra("repetir", list.get(auxPosition).getRepetir());
                intent.putExtra("descricao", list.get(auxPosition).getDescricao());
                intent.putExtra("id", list.get(auxPosition).getId());
                context.startActivity(intent);
            }
        });

        Button deletarBt = (Button) layout.findViewById(R.id.deletar);
        deletarBt.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                BD bd = new BD(context);
                bd.deletar(list.get(auxPosition));

                layout.setVisibility(View.GONE);
            }
        });

        return layout;
    }

}
