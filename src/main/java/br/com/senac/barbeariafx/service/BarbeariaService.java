package br.com.senac.barbeariafx.service;

import br.com.senac.barbeariafx.model.Barbearia;
import br.com.senac.barbeariafx.repository.Barbearias;

import java.util.List;

public class BarbeariaService implements Barbearias {
    final String USUARIO = "root";
    final String SENHA = "root";
    final String URL_BANCO = "jdbc:mysql://localhost:3306/senac_barbearia";
    final String CLASSE_DRIVER = "com.mysql.jdbc.Driver";

    @Override
    public void salvarBarberia(Barbearia barbearia) {

    }

    @Override
    public Barbearia buscarUmHorario(int id) {
        return null;
    }

    @Override
    public List<Barbearia> buscarTodosOsHorarios() {
        return null;
    }
}
