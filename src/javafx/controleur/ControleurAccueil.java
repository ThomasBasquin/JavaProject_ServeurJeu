package javafx.controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        root = FXMLLoader.load(getClass().getResource("../vue/VueAllumette.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
