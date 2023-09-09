package gui.controlers;

import gui.ScreamControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import negocio.ControladorUsuarios;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControlerLogin implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        senha.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                fazerLogin();
            }
        });

        login.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                fazerLogin();
            }
        });
    }

    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    @FXML
    private Label testador;

    @FXML
    void criaNovaConta(ActionEvent event) throws IOException {

        ScreamControl.telaCadastro();
    }

    @FXML
    void fazerLogin() {
        String usuario = login.getText();
        String key = senha.getText();
        try {
            ControladorUsuarios.getInstance().fazerLogin(usuario,key);
            System.out.println("sucesso!!!");
            ScreamControl.telaPrincipal();
        }
        catch (Exception a ){
            testador.setText("*usuario ou senha errados");
        }
    }

    @FXML
    void fecha(ActionEvent event) {

        ScreamControl.fechar();

    }

}
