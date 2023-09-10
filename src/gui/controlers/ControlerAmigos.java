package gui.controlers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class ControlerAmigos {

    @FXML
    private Label email;

    @FXML
    private Label exceptions;

    @FXML
    private Label nomeDeUsuario;

    @FXML
    private TextField pesquisa;

    @FXML
    private JFXButton qtSeguidores;

    @FXML
    private JFXButton qtSeguindo;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private TitledPane tp1;

    @FXML
    private VBox vboxSeguidores;

    @FXML
    private VBox vboxSeguindo;

    @FXML
    void pesquisar(ActionEvent event) {

    }

}
