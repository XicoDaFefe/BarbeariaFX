package br.com.senac.barbeariafx.model;

import java.util.Date;

public class Barbearia {
    private int id;
    private String agendar;
    private String clientes;
    private String cortes;
    private Date dia;
    private String horario;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String gethorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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


    public Date getDia() {
        return dia;
    }
    public void setDia(Date dia){
    this.dia = dia;
}
}
