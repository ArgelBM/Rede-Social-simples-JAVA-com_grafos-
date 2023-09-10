package gui.controlers;

import com.jfoenix.controls.JFXButton;
import dados.RepositorioGeral;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import negocio.ControladorUsuarios;
import negocio.beans.Graph;
import negocio.beans.Vertex;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlerPerfil implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (RepositorioGeral.getRepositorioGeral().verifica(ControladorUsuarios.getInstance().getUsuarioAtivo().getId(),getPerfil())){
            botaoSeguir.setText("REMOVER -");
        }else {
            botaoSeguir.setText("ADD -");
        }
    }
    private Vertex Perfil;

    @FXML
    public JFXButton botaoSeguir;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label emailUsuario;

    @FXML
    private HBox item;

    @FXML
    private Label nomeUsuario;

    public String getEmailUsuario() {
        return emailUsuario.getText();
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario.setText(emailUsuario);
    }

    public String getNomeUsuario() {
        return nomeUsuario.getText();
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario.setText(nomeUsuario);
    }

    public Vertex getPerfil() {
        return Perfil;
    }

    public void setPerfil(Vertex perfil) {
        Perfil = perfil;
    }

    @FXML
    void removerSeguidor(ActionEvent event) {



    }

    @FXML
    void seguir(ActionEvent event) {

        RepositorioGeral.getInstance().seguir(ControladorUsuarios.getInstance().getUsuarioAtivo().getId(),getPerfil());
        System.out.println(RepositorioGeral.getInstance().getGraph().getEdges());

        if (RepositorioGeral.getRepositorioGeral().verifica(ControladorUsuarios.getInstance().getUsuarioAtivo().getId(),getPerfil())){
            botaoSeguir.setText("REMOVER -");
        }else {
            botaoSeguir.setText("ADD -");
        }
    }


}
