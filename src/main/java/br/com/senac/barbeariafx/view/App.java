package br.com.senac.barbeariafx.view;

import br.com.senac.barbeariafx.model.Barbearia;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(App.class.getResource("/gui/barbearias.fxml"));
        stage.setTitle("Barbearia");
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
