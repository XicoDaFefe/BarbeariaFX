package br.com.senac.barbeariafx.service;

import br.com.senac.barbeariafx.model.Barbearia;
import br.com.senac.barbeariafx.repository.Barbearias;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BarbeariaService implements Barbearias {
    final String USUARIO = "root";
    final String SENHA = "root";
    final String URL_BANCO = "jdbc:mysql://localhost:3306/senac_barbearia";
    final String CLASSE_DRIVER = "com.mysql.jdbc.Driver";

    final String INSERIR = "INSERT INTO barbearia(cliente, corte, horario " +
            "dia) VALUES(?, ?, ?, ?)";
    final String BUSCAR_TODAS = "SELECT id, cliente, corte, horario " +
            "dia FROM barbearia";
    final String BUSCAR = "SELECT id, cliente, corte, horario" +
            "dia FROM barbearia  WHERE id = ?";
    final String FORMATO_DATA = "yyyy-MM-dd";
    final SimpleDateFormat FORMATADOR = new SimpleDateFormat(FORMATO_DATA);


    private Connection conexao(){
        try{
            Class.forName(CLASSE_DRIVER);
            return DriverManager.getConnection(URL_BANCO, USUARIO, SENHA);
        } catch (Exception e){
            e.printStackTrace();
            if(e instanceof ClassNotFoundException) {
                System.out.println("VERIFIQUE SE O DRIVER DO BANCO DE DADOS" +
                        "ESTA NO CLASSPATH DO PROJETO");
            } else {
                System.out.println("VERIFIQUE SE O BANCO DE DADOS ESTÁ" +
                        "RODANDO E SE OS DADOS DE CONEXAO ESTÃO CORRETOS");
            }
            System.exit(0);
            return null;
        }

    }
    @Override
    public void salvarBarberia(Barbearia barbearia) {
        try{
            Connection con = conexao();
            PreparedStatement salvar = con.prepareStatement(INSERIR);
            String dateStr = formataDataD(barbearia.getDia());
            salvar.setString(1, barbearia.getClientes());
            salvar.setString(2, barbearia.getCortes());
            salvar.setString(3, barbearia.getHorario());
            salvar.setString(4, dateStr);
            salvar.executeUpdate();
            salvar.close();
            con.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("ERRO SALVANDO HORARIO");
            System.exit(0);
        }

    }

    private String formataDataD(Date dia) {
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = data.format(dia);
        return dataFormatada;
    }

    @Override
    public Barbearia buscarUmHorario(int id) {
        Barbearia barbearia = null;
    try {
            Connection con = conexao();
            PreparedStatement buscar = con.prepareStatement(BUSCAR);
            buscar.setInt(1,id);

        ResultSet resuldatoBusca = buscar.executeQuery();
        resuldatoBusca.next();
        barbearia = extraiBarbearia(resuldatoBusca);
        buscar.close();
        con.close();
    }catch (Exception e){
        e.printStackTrace();
        System.out.println("ERRO BUSCANDO UM HORARIO COM O ID" + id);
        System.exit(0);
    }

        return barbearia;
    }

    private Barbearia extraiBarbearia(ResultSet resuldatoBusca) throws SQLException, ParseException {
        Barbearia barbearia = new Barbearia();
        barbearia.setId(resuldatoBusca.getInt(1));
        barbearia.setClientes(resuldatoBusca.getString(2));
        barbearia.setCortes(resuldatoBusca.getString(3));
        barbearia.setHorario(resuldatoBusca.getString(4));
        Date dia = FORMATADOR.parse(resuldatoBusca.getString(5));
        barbearia.setDia(dia);
        return barbearia;
    }

    @Override
    public List<Barbearia> buscarTodosOsHorarios() {
        return null;
    }
}
