package br.com.senac.barbeariafx.repository;

import br.com.senac.barbeariafx.model.Barbearia;
import br.com.senac.barbeariafx.service.BarbeariaService;

import java.util.List;

public interface Barbearias {

    public void salvarBarberia(Barbearia barbearia);

    public List <Barbearia> buscarTodosOsHorarios;

    public Barbearia buscarUmHorario(int id);

    public static Barbearias getNewInstance(){

        return new BarbeariaService();
    }


}
