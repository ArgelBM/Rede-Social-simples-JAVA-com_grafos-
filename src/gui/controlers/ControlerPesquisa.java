
package gui.controlers;

import dados.RepositorioGeral;
import gui.ScreamControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import negocio.ControladorUsuarios;
import negocio.beans.Posts;
import negocio.beans.Usuario;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControlerPesquisa {

    @FXML
    private Label exceptions;

    @FXML
    private VBox listaDeUsuariosPesquisados;

    public void pesquisar() throws IOException {

        try {
            ControlerPrincipal controlerPrincipal = (ControlerPrincipal) ScreamControl.getControler();
            List<Usuario> usuariosPesquisados = new ArrayList<>();
            System.out.println(RepositorioGeral.getInstance().getUserList());
            for (Usuario usuario : RepositorioGeral.getInstance().getUserList()) {
                System.out.println(controlerPrincipal.getPesquisa().toLowerCase());
                System.out.println(usuario.getNomeUsuario().toLowerCase().substring(0, controlerPrincipal.getPesquisa().length()));
                if (controlerPrincipal.getPesquisa().toLowerCase().equals(usuario.getNomeUsuario().toLowerCase().substring(0, controlerPrincipal.getPesquisa().length()))) {
                    System.out.println("in" + controlerPrincipal.getPesquisa().toLowerCase());
                    System.out.println("in" + usuario.getNomeUsuario().toLowerCase().substring(0, controlerPrincipal.getPesquisa().length()));
                    usuariosPesquisados.add(usuario);
                    System.out.println("usuario :" + usuario.getNomeUsuario());
                }
                exceptions.setText("");
            }
            for (Usuario usuario : usuariosPesquisados){
                FXMLLoader tela = new FXMLLoader(getClass().getResource("/gui/fxml/Perfil.fxml"));
                HBox item = tela.load();
                ControlerPerfil controlerPerfil = tela.getController();
                controlerPerfil.setEmailUsuario(usuario.getLogin());
                controlerPerfil.setNomeUsuario(usuario.getNomeUsuario());
                controlerPerfil.setPerfil(usuario.getId());
                if (RepositorioGeral.getRepositorioGeral().verifica(ControladorUsuarios.getInstance().getUsuarioAtivo().getId(),controlerPerfil.getPerfil())){
                    controlerPerfil.botaoSeguir.setText("REMOVER -");
                }else {
                    controlerPerfil.botaoSeguir.setText("ADD -");
                }
                listaDeUsuariosPesquisados.getChildren().add(item);
            }
        }
        catch (Exception e){
            System.out.println(e);
            exceptions.setText("Usuario n existe");
        }
    }
}

