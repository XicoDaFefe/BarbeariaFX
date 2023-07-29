module br.com.senac.barbeariafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens br.com.senac.barbeariafx to javafx.fxml;
    exports br.com.senac.barbeariafx;
}