package br.com.senac.barbeariafx.model;

import java.util.Date;

public class Barbearia {
    private int id;
    private String agendar;
    private String clientes;
    private String cortes;
    private Date horarioInicio;
    private Date horarioTermino;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(Date horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public Date getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(Date horarioTermino) {
        this.horarioTermino = horarioTermino;
    }

    public String getAgendar() {
        return agendar;
    }

    public void setAgendar(String agendar) {
        this.agendar = agendar;
    }

    public String getClientes() {
        return clientes;
    }

    public void setClientes(String clientes) {
        this.clientes = clientes;
    }

    public String getCortes() {
        return cortes;
    }

    public void setCortes(String cortes) {
        this.cortes = cortes;
    }
}
