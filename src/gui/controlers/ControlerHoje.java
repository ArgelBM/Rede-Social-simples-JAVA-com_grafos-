package gui.controlers;

import dados.RepositorioGeral;
import gui.ScreamControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import negocio.ControladorUsuarios;
import negocio.beans.Posts;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class ControlerHoje implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            atualizarFeed();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private TextField novaPost;
    @FXML
    private VBox postagens;
    @FXML
    private ScrollPane scrollpane;
    @FXML
    void adicionarPost(ActionEvent event) throws IOException {
        ControladorUsuarios.getInstance().getUsuarioAtivo().addPosts(new Posts(novaPost.getText()));
        novaPost.setText("");
        atualizarFeed();
        System.out.println(ControladorUsuarios.getInstance().getUsuarioAtivo().getPosts());
        ControlerPrincipal controler = (ControlerPrincipal) ScreamControl.getControler();
        controler.carregarPosts();
    }

    void incertionSort(List<Posts> posts){
        int j;
        Posts key;
        int i;
        for (j = 1; j < posts.size(); j++)
        {
            key = posts.get(j);
            for (i = j - 1; (i >= 0) && (posts.get(i).getHorario().isAfter(key.getHorario()) ); i--)
            {
                posts.set((i+1), posts.get(i));
            }
            posts.set((i+1), key);
        }
    }

    void atualizarFeed() throws IOException {
       List<Posts> lista = RepositorioGeral.getInstance().getGraph().getFeedByUser();
       incertionSort(lista);
       Collections.reverse(lista);
        for (Posts posts : lista){
            FXMLLoader tela = new FXMLLoader(getClass().getResource("/gui/fxml/Item.fxml"));
            HBox item = tela.load();
            ControlerItem controler = tela.getController();
            DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            controler.setData(posts.getHorario().format(formatoBrasileiro));
            controler.setUserName(posts.getUsuario());
            controler.setNomeLabel(posts.getConteudo());
            postagens.getChildren().add(item);
        }
    }
}
