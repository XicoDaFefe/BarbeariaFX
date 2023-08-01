package br.com.senac.barbeariafx.controller;

import br.com.senac.barbeariafx.model.Barbearia;
import br.com.senac.barbeariafx.repository.Barbearias;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class BarbeariasController implements Initializable {

    @FXML
    private TextField txtCliente;
    @FXML
    private TextField txtCortes;
    @FXML
    private TextField txtHora;
    @FXML
    private DatePicker dpDia;
    @FXML
    private TableView <Barbearia> tblBarbearias;
    @FXML
    private Button btnMarcar;
    @FXML
    private TableColumn<Barbearia, String> clCliente;
    @FXML
    private TableColumn<Barbearia, String> clCorte;
    @FXML
    private TableColumn<Barbearia, String> clHorario;
    @FXML
    private TableColumn<Barbearia, String> clDia;
    private Barbearias barbearias;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    barbearias =Barbearias.getNewInstance();
    configuraColunas();
    configuraTela();
    atualizaDados();

    }

    private void atualizaDados() {
        tblBarbearias.getItems().setAll(barbearias.buscarTodosOsHorarios());
    }

    private void configuraTela() {
        BooleanBinding camposPreenchidos = txtCliente.textProperty()
                .isEmpty().or(txtCortes.textProperty().isEmpty()).or(txtHora.textProperty().isEmpty())
                .or(dpDia.valueProperty().isNull());

            BooleanBinding barbeariaSelecionada = tblBarbearias.getSelectionModel().selectedItemProperty().isNull();

            btnMarcar.disableProperty().bind(barbeariaSelecionada.not().or(camposPreenchidos));

        tblBarbearias.getSelectionModel().selectedItemProperty().addListener(
                (b, o, n) -> {
                    if(n != null){
                        LocalDate data = null;
                        data = n.getDia()
                                .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        txtCliente.setText(n.getClientes());
                        txtCortes.setText(n.getCortes());
                        dpDia.setValue(data);
                    }
                }
        );
    }


    private void configuraColunas() {
    clCliente.setCellValueFactory(new PropertyValueFactory<>("Clientes"));
    clCorte.setCellValueFactory(new PropertyValueFactory<>("Cortes"));
    clHorario.setCellValueFactory(new PropertyValueFactory<>("Horario"));
    clDia.setCellValueFactory(cellData ->{
        Date data =cellData.getValue().getDia();
        DateFormat formataData = new SimpleDateFormat("dd/MM/YYYY");
        String dataFormatada =formataData.format(data);
        return new SimpleStringProperty(dataFormatada);
    }
    );
    }

    public void marcar(){
        Barbearia barbearia = new Barbearia();
        pegaValores(barbearia);
        barbearias.salvarBarberia(barbearia);
        atualizaDados();
    }

    private void pegaValores(Barbearia barbearia) {
        barbearia.setClientes(txtCliente.getText());
        barbearia.setCortes(txtCortes.getText());
        barbearia.setHorario(txtHora.getText());
        barbearia.setDia(dataSelecionada());
    }

    private Date dataSelecionada() {
        LocalDateTime time = dpDia.getValue().atStartOfDay();
        System.out.println(Date.from(time.atZone(ZoneId.systemDefault()).toInstant()));
        return  Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }
}
