package gui.controlers;

import de.jensd.fx.glyphs.materialicons.MaterialIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

public class ControlerItem {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Circle bola;

    @FXML
    private Label data;

    @FXML
    private Button favoritar;

    @FXML
    private HBox item;

    @FXML
    private Label lista;

    @FXML
    private Label nomeLabel;

    @FXML
    private MaterialIconView star;

    @FXML
    void modifica(MouseEvent event) {

    }

    @FXML
    void mudaCor(MouseEvent event) {

    }

    @FXML
    void mudaCorDeVolta(MouseEvent event) {

    }

    @FXML
    void setFavoritar(ActionEvent event) {

    }

    public Label getData() {
        return data;
    }

    public void setData(String data) {
        this.data.setText(data);
    }

    public Label getLista() {
        return lista;
    }

    public void setUserName(String usuario) {
        this.lista.setText(usuario);
    }

    public Label getNomeLabel() {
        return nomeLabel;
    }

    public void setNomeLabel(Label nomeLabel) {
        this.nomeLabel = nomeLabel;
    }
}
