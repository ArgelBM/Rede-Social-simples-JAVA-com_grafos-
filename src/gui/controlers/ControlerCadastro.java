package gui.controlers;

import gui.ScreamControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import negocio.ControladorUsuarios;
import negocio.beans.Usuario;
import negocio.beans.Vertex;

import java.io.IOException;

public class ControlerCadastro {

    @FXML
    private TextField cpf;

    @FXML
    private ChoiceBox<?> email;

    @FXML
    private Label erro;

    @FXML
    private TextField login;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField userName;

    @FXML
    void cadastrar(ActionEvent event) {

        try {
            ControladorUsuarios.getInstance().adicionar(new Usuario(userName.getText(),login.getText(),senha.getText(),
                    cpf.getText(), new Vertex(userName.getText(),cpf.getText())));
            ScreamControl.telaLogin();
        }
        catch (NullPointerException a){
            erro.setText("Os campos estão vazios");
            System.out.println("erro");
            System.out.println(a);
        }
        catch (IllegalArgumentException b){
            erro.setText("Esse usuário já existe");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void fecha(ActionEvent event) {


    }

    @FXML
    void login(ActionEvent event) throws IOException {

        ScreamControl.telaLogin();

    }

}
