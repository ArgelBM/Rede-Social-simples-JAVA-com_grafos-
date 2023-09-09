package gui;

import gui.controlers.ControlerInicial;
import gui.controlers.ControlerPrincipal;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScreamControl {

    private static Object controler;
    private static Object subControler;
    private static Stage stage = Main.getStage();

    public static void iniciar() throws IOException {
                stage.close();
                FXMLLoader loader = new FXMLLoader(ScreamControl.class.getResource("/gui/fxml/TelaInicial.fxml"));
                Parent root = loader.load();
                controler = loader.getController();
                Scene mainScene = new Scene(root, 700, 500);
                stage.setTitle("Rede social (:");
                stage.setScene(mainScene);
                stage.show();
            }

    public static void setControler(Object controler) {
        ScreamControl.controler = controler;
    }

    public static Object getControler(){
        return controler;
    }

    public static void fechar(){
        stage.close();
    }

    public static void telaCadastro() throws IOException {
        ControlerInicial controler = (ControlerInicial)ScreamControl.getControler();
        controler.carregarTelaCadastro();
    }

    public static void telaLogin() throws IOException {
        ControlerInicial controler = (ControlerInicial)ScreamControl.getControler();
        controler.carregarTelaLogin();
    }

    public static void telaPrincipal() throws IOException {

        stage.close();
        FXMLLoader loader = new FXMLLoader(ScreamControl.class.getResource("/gui/fxml/TelaPrincipal.fxml"));
        Parent root = loader.load();
        controler = loader.getController();
        Scene mainScene = new Scene(root, 1000, 664);
        stage.setTitle("Rede social (:");
        stage.setScene(mainScene);
        stage.show();

    }

    public static void telaPostagens() throws IOException {
        FXMLLoader loader = new FXMLLoader(ScreamControl.class.getResource("/gui/fxml/Hoje.fxml"));
        Parent root = loader.load();

        ControlerPrincipal controler = (ControlerPrincipal)ScreamControl.getControler();
        controler.getContentArea().setCenter(root);
    }
}
