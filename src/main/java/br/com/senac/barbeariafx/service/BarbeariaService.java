package br.com.senac.barbeariafx.service;

import br.com.senac.barbeariafx.model.Barbearia;
import br.com.senac.barbeariafx.repository.Barbearias;

<<<<<<< Updated upstream
=======
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

>>>>>>> Stashed changes
public class BarbeariaService implements Barbearias {

    final String USUARIO = "root";
    final String SENHA = "root";
    final String URL_BANCO = "jdbc:mysql://localhost:3306/senac_barbearia";
    final String CLASSE_DRIVER = "com.mysql.jdbc.Driver";
    final String INSERIR = "INSERT INTO barbearia(cliente, corte, horario, " +
            "dia) VALUES(?, ?, ?, ?)";
    final String BUSCAR_TODAS = "SELECT id, cliente, corte, horario, " +
            "dia FROM barbearia";
    final String BUSCAR = "SELECT id, cliente, corte, horario," +
            "dia FROM barbearia  WHERE id = ?";
    final String FORMATO_DATA = "yyyy-MM-dd";
    final SimpleDateFormat FORMATADOR = new SimpleDateFormat(FORMATO_DATA);

    private Connection conexao(){
        try {
                Class.forName(CLASSE_DRIVER);
                return DriverManager.getConnection(URL_BANCO, USUARIO, SENHA);
        } catch (Exception e){
            e.printStackTrace();
            if (e instanceof ClassNotFoundException){
                System.out.println("VERIFIQUE SE O DRIVER DO BANCO DE DADOS" +
                        "ESTA NO CLASSPATH DO PROJETO");
            } else{
                System.out.println("VERIFIQUE SE O BANCO DE DADOS ESTÁ" +
                        "RODANDO E SE OS DADOS DE CONEXAO ESTÃO CORRETOS");
            }
            System.exit(0);
                return null;
        }
    }

    @Override
    public void salvarBarberia(Barbearia barbearia) {
        try {
            Connection con = conexao();
            PreparedStatement salvar = con.prepareStatement(INSERIR);
            String datestr =formataDatadb(barbearia.getDia());
            salvar.setString(1, barbearia.getClientes());
            salvar.setString(2, barbearia.getCortes());
            salvar.setString(3, barbearia.gethorario());
            salvar.setString(4, datestr);
            salvar.executeUpdate();
            salvar.close();
            con.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("ERRO SALVAND0 BARBEARIA");
            System.exit(0);
        }

    }

    private String formataDatadb(Date dia){
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
            buscar.setInt(1, id);
            ResultSet resultadoBusca = buscar.executeQuery();
            resultadoBusca.next();
            barbearia = extraiBarbearia(resultadoBusca);
            buscar.close();
            con.close();
        } catch (Exception e ){
            e.printStackTrace();
            System.out.println("ERRO BUSCANDO UM HORARIO COM O ID" + id);
            System.exit(0);
        }return barbearia;
    }

    private Barbearia extraiBarbearia(ResultSet resultadoBusca) throws SQLException, ParseException {
        Barbearia barbearia = new Barbearia();
        barbearia.setId(resultadoBusca.getInt(1));
        barbearia.setClientes(resultadoBusca.getString(2));
        barbearia.setCortes(resultadoBusca.getString(3));
        barbearia.setHorario(resultadoBusca.getString(4));
        Date dia =FORMATADOR.parse(resultadoBusca.getString(5));
        barbearia.getDia();
        return barbearia;
    }
<<<<<<< Updated upstream
=======

    @Override
    public List<Barbearia> buscarTodosOsHorarios() {
        List<Barbearia> barbearias = new ArrayList<>();

        try {
            Connection con = conexao();
            PreparedStatement buscarTodos = con.prepareStatement(BUSCAR_TODAS);
            ResultSet resultadoBusca = buscarTodos.executeQuery();
            while (resultadoBusca.next()){
            Barbearia barbearia = extraiBarbearia(resultadoBusca);
            barbearias.add(barbearia);
            }
            buscarTodos.close();
            con.close();
        }catch (Exception e){
        e.printStackTrace();
            System.out.println("Erro buscando todos os horarios.");
            System.exit(0);
        }
        return barbearias;
    }
>>>>>>> Stashed changes
}
