package com.bga.agenda;

import android.widget.Spinner;

import java.util.ArrayList;

public class Evento {
    private String nome;
    private String tiposelecionado;
    private String data;
    private String horainicio;
    private String horatermino;
    private String local;
    private String repetirtxt;
    private String repetir;
    private String pesquisa;
    private String pesquisa_evento;


    public String getPesquisa_evento() {
        return pesquisa_evento;
    }

    public void setPesquisa_evento(String pesquisa_evento) {
        this.pesquisa_evento = pesquisa_evento;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public String getRepetirtxt() {
        return repetirtxt;
    }

    public void setRepetirtxt(String repetirtxt) {
        this.repetirtxt = repetirtxt;
    }

    public String getTiposelecionado() {
        return tiposelecionado;
    }

    public void setTiposelecionado(String tiposelecionado) {
        this.tiposelecionado = tiposelecionado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getRepetir() {
        return repetir;
    }

    public void setRepetir(String repetir) {
        this.repetir = repetir;
    }

    private String descricao;

    public String getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    private String participantes;
    private long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHoratermino() {
        return horatermino;
    }

    public void setHoratermino(String horatermino) {
        this.horatermino = horatermino;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


}


