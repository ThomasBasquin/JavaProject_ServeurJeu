package Controler;


import Model.methodePendu.ImplPendu;
import Model.methodePendu.InterfacePendu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.rmi.Naming;
import java.util.ResourceBundle;

public class ControleurPendu implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button buttonQuitter;

    @FXML
    private Button buttonRegles;

    @FXML
    private Button buttonRestart;

    @FXML
    private Label labelMot;

    @FXML
    private TextField tfpendu;

    @FXML
    private Line pendu1;

    @FXML
    private Line pendu10;

    @FXML
    private Line pendu11;

    @FXML
    private Line pendu2;

    @FXML
    private Line pendu3;

    @FXML
    private Line pendu4;

    @FXML
    private Line pendu5;

    @FXML
    private Circle pendu6;

    @FXML
    private Line pendu7;

    @FXML
    private Line pendu8;

    @FXML
    private Line pendu9;


    InterfacePendu pendu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    void goToPageAccueil(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Vue/VueAccueil.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openRegles(ActionEvent event) {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setResizable(false);
        dialog.setTitle("Regles du jeu - Le pendu");
        dialog.setContentText("Le pendu c'est mal");
        dialog.showAndWait();
    }



}
