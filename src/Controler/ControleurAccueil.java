package Controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ControleurAccueil {

    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML
    private Button buttonAlban;


    @FXML
    private Button buttonNathan;

    @FXML
    private Button buttonThomas;

    @FXML
    public Button buttonAllumette;
    @FXML
    private Button buttonInfo;


    @FXML
    void goToGitHub(ActionEvent event) throws URISyntaxException, IOException {

        if(event.getSource() == buttonAlban) {
            Desktop.getDesktop().browse(new URI("https://github.com/Alban-Ktz"));
        } else if (event.getSource() == buttonThomas) {
            Desktop.getDesktop().browse(new URI("https://github.com/ThomasBasquin"));
        } else if (event.getSource() == buttonNathan) {
            Desktop.getDesktop().browse(new URI("https://github.com/nat1103"));
        }

    }

    public void goToVueAllumette(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Vue/VueAllumette2.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void goToVueTicTacToe(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Vue/VueTicTacToe.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void goToVuePendu(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Vue/VuePendu.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void openInfo(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informations");
        alert.setHeaderText("Projet Programmation repartie");
        alert.setContentText("Pour plus d'informations, consultez notre GitHub : https://github.com/ThomasBasquin/JavaProject_ServeurJeu");
        alert.showAndWait();
    }
}
