package gui.controlers;

import gui.ScreamControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import negocio.ControladorUsuarios;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControlerPrincipal implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        login.setText(ControladorUsuarios.getInstance().getUsuarioAtivo().getLogin());
        nomeDeUsuario.setText(ControladorUsuarios.getInstance().getUsuarioAtivo().getNomeUsuario());
//        try {
//            System.out.println("teste");
//            ScreamControl.telaPostagens();
//            System.out.println("t");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }

    @FXML
    private BorderPane contentArea;

    @FXML
    private TextField pesquisa;

    @FXML
    private Label login;

    @FXML
    private Label nomeDeUsuario;

    @FXML
    private VBox vsp;

    @FXML
    void mostrarAmigos(ActionEvent event) {

    }

    @FXML
    void mostrarIndicacoes(ActionEvent event) {

    }

    @FXML
    void mostrarPosts(ActionEvent event) {

    }

    @FXML
    void sair(ActionEvent event) throws IOException {

        ControladorUsuarios.getInstance().sair();
        ScreamControl.iniciar();

    }

    @FXML
    void telaConfiguracao(ActionEvent event) {

    }

    @FXML
    void pesquisar(ActionEvent event) {

    }

    public BorderPane getContentArea() {
        return contentArea;
    }
}
