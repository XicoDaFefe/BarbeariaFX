module br.com.senac.barbeariafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens br.com.senac.barbeariafx to javafx.fxml;
    exports br.com.senac.barbeariafx;

    opens br.com.senac.barbeariafx.controller to javafx.fxml;
    exports br.com.senac.barbeariafx.controller;

    opens br.com.senac.barbeariafx.view to javafx.fxml;
    exports br.com.senac.barbeariafx.view;

    opens br.com.senac.barbeariafx.model to javafx.fxml;
    exports br.com.senac.barbeariafx.model;
}