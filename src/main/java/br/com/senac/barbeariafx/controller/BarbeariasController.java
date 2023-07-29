package br.com.senac.barbeariafx.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class BarbeariasController implements Initializable {
<<<<<<< Updated upstream
=======

    @FXML
    private TextField txtCliente;
    @FXML
    private TextField txtCortes;
    @FXML
    private TextField txtHorario;
    @FXML
    private DatePicker dpDia;
    @FXML
    private TableView <Barbearia> tblHorarios;
    @FXML
    private Button btnMarcar;
    @FXML
    private TableColumn<Barbearia, String> clCliente;
    @FXML
    private TableColumn<Barbearia, String> clCorte;
    @FXML
    private TableColumn<Barbearia, String> clDiaCorte;
    @FXML
    private  TableColumn<Barbearia, String> clHorario;
    private Barbearias barbearias;
>>>>>>> Stashed changes
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
<<<<<<< Updated upstream
=======

    private void atualizaDados() {
        tblHorarios.getItems().setAll(barbearias.buscarTodosOsHorarios());
    }

    private void configuraTela() {
        BooleanBinding camposPreenchidos = txtCliente.textProperty().isEmpty().or(txtCortes.textProperty().isEmpty())
                .or(txtHorario.textProperty().isEmpty()).or(dpDia.valueProperty().isNull());

            BooleanBinding horarioSelecionado =tblHorarios.getSelectionModel().selectedItemProperty().isNull();

            btnMarcar.disableProperty().bind(camposPreenchidos);

        tblHorarios.getSelectionModel().selectedItemProperty().addListener(
                (b, o, n) -> {
                    if(n != null){
                        LocalDate data = null;
                        data = n.getDia()
                                .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        txtCliente.setText(n.getClientes());
                        txtCortes.setText(n.getCortes());
                        txtHorario.setText(n.gethorario());
                        dpDia.setValue(data);
                    }
                }
        );
    }


    private void configuraColunas() {
    clCliente.setCellValueFactory(new PropertyValueFactory<>("Cliente"));
    clCorte.setCellValueFactory(new PropertyValueFactory<>("Corte"));
    clHorario.setCellValueFactory(new PropertyValueFactory<>("Horário"));
    clDiaCorte.setCellValueFactory(cellData ->{
        Date data =cellData.getValue().getDia();
        DateFormat formataData = new SimpleDateFormat("dd/MM/YYYY");
        String dataFormatada =formataData.format(data);
        return new SimpleStringProperty(dataFormatada);
    });
    }


>>>>>>> Stashed changes
}
