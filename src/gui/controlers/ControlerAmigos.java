package gui.controlers;

import com.jfoenix.controls.JFXButton;
import dados.RepositorioGeral;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import negocio.ControladorUsuarios;
import negocio.beans.Vertex;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControlerAmigos implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int seguidores = 0;
        int seguindo= 0;

        for (Vertex vertex : RepositorioGeral.getInstance().getGraph()
                .getSeguindo(ControladorUsuarios.getInstance().getUsuarioAtivo().getId())){

            seguindo += 1;

            try {
                FXMLLoader tela = new FXMLLoader(getClass().getResource("/gui/fxml/Perfil.fxml"));
                HBox item = tela.load();
                ControlerPerfil controlerPerfil = tela.getController();
                controlerPerfil.setEmailUsuario(RepositorioGeral.getInstance().findByVertex(vertex).getLogin());
                controlerPerfil.setNomeUsuario(RepositorioGeral.getInstance().findByVertex(vertex).getNomeUsuario());
                controlerPerfil.setPerfil(RepositorioGeral.getInstance().findByVertex(vertex).getId());
                if (RepositorioGeral.getRepositorioGeral().verifica(ControladorUsuarios.getInstance().getUsuarioAtivo().getId(),controlerPerfil.getPerfil())){
                    controlerPerfil.botaoSeguir.setText("REMOVER -");
                }else {
                    controlerPerfil.botaoSeguir.setText("ADD -");
                }
                vboxSeguindo.getChildren().add(item);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        for (Vertex vertex : RepositorioGeral.getInstance().getGraph()
                .getSeguidores(ControladorUsuarios.getInstance().getUsuarioAtivo().getId())) {

            seguidores += 1;

            try {
                FXMLLoader tela = new FXMLLoader(getClass().getResource("/gui/fxml/Perfil.fxml"));
                HBox item = tela.load();
                ControlerPerfil controlerPerfil = tela.getController();
                controlerPerfil.setEmailUsuario(RepositorioGeral.getInstance().findByVertex(vertex).getLogin());
                controlerPerfil.setNomeUsuario(RepositorioGeral.getInstance().findByVertex(vertex).getNomeUsuario());
                controlerPerfil.setPerfil(RepositorioGeral.getInstance().findByVertex(vertex).getId());
                if (RepositorioGeral.getRepositorioGeral().verifica(ControladorUsuarios.getInstance().getUsuarioAtivo().getId(), controlerPerfil.getPerfil())) {
                    controlerPerfil.botaoSeguir.setText("REMOVER -");
                } else {
                    controlerPerfil.botaoSeguir.setText("ADD -");
                }
                vboxSeguidores.getChildren().add(item);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        qtSeguidores1.setText(Integer.toString(seguidores));
        qtSeguindo1.setText(Integer.toString(seguindo));
        email.setText(ControladorUsuarios.getInstance().getUsuarioAtivo().getLogin());
        nomeDeUsuario.setText(ControladorUsuarios.getInstance().getUsuarioAtivo().getNomeUsuario());

    }

    @FXML
    private Label email;

    @FXML
    private Label exceptions;

    @FXML
    private Label exceptions1;

    @FXML
    private Label exceptions11;

    @FXML
    private Label nomeDeUsuario;

    @FXML
    private JFXButton qtSeguidores1;

    @FXML
    private JFXButton qtSeguindo1;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private TitledPane tp1;

    @FXML
    private VBox vboxSeguidores;

    @FXML
    private VBox vboxSeguindo;


}
