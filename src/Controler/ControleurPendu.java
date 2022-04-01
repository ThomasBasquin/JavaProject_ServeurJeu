package Controler;


import Model.methodePendu.InterfacePendu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControleurPendu implements Initializable {

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

    public void initializationPartie() throws IOException {
        pendu1.setVisible(false);
        pendu2.setVisible(false);
        pendu3.setVisible(false);
        pendu4.setVisible(false);
        pendu5.setVisible(false);
        pendu6.setVisible(false);
        pendu7.setVisible(false);
        pendu8.setVisible(false);
        pendu9.setVisible(false);
        pendu10.setVisible(false);
        pendu11.setVisible(false);

        pendu.setGagner(false);
        pendu.setFaute(0);

        //On remet à zéro les mots trouver
        pendu.setLettreTrouve(new ArrayList<>());
        //set le mot aléatoire du dictionnaire
        pendu.setMot();
        System.out.println(pendu.getMot());
        //set la liste des lettres du mot
        pendu.setLettresDuMot();
        System.out.println(pendu.getLettresDuMot());
        //affiche les tiret du bas
        labelMot.setText(pendu.affichageDuMotUnderscore());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            int port = 8000;
            pendu = (InterfacePendu) Naming.lookup(
                    "rmi://localhost:" + port + "/pendu"); //Recherche du serveur
            initializationPartie();
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }

    }

    //Bouton rejouer
    @FXML
    private void RejouerPendu(ActionEvent actionEvent) throws IOException {
        initializationPartie();
    }

    //Saisie d'un caractère dans le textfield
    public void onEnter(ActionEvent actionEvent) throws IOException {
        String key = tfpendu.getText();
        String msg = new String();
        tfpendu.setText("");
        if (key == " ") {
            msg = "Merci de saisir un champ valide";
        }
        labelMot.setText(pendu.affichageDuMot(key.charAt(0)));
        if (pendu.isGagner()){
            Rejouer(false);
        }
        afficherPendu();

    }

    //Afficher le pendu
    public void afficherPendu() throws IOException {
        switch (pendu.getFaute()){
            case 1:
                pendu1.setVisible(true);
                break;
            case 2:
                pendu2.setVisible(true);
                break;
            case 3:
                pendu3.setVisible(true);
                break;
            case 4:
                pendu4.setVisible(true);
                break;
            case 5:
                pendu5.setVisible(true);
                break;
            case 6:
                pendu6.setVisible(true);
                break;
            case 7:
                pendu7.setVisible(true);
                break;
            case 8:
                pendu8.setVisible(true);
                break;
            case 9:
                pendu9.setVisible(true);
                break;
            case 10:
                pendu10.setVisible(true);
                break;
            case 11:
                pendu11.setVisible(true);
                Rejouer(true);
                break;
        }

    }

    //Annonce de rejouer quand partie finit
    public void Rejouer(boolean perdu) throws IOException {
        String message;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        if (perdu){
            message = "Desoler vous n'avez pas trouver le mot";
            alert.setTitle("Perdu !");
        }else{
            message ="Bravo vous avez gagner";
            alert.setTitle("Gagner !");
        }
        alert.setHeaderText(message);
        alert.setContentText("Voulez-vous rejouer ?");

        // option != null.
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == ButtonType.OK) {
            initializationPartie();
        }

    }

    @FXML
    void goToPageAccueil(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Vue/VueAccueil.fxml"));
        scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void openRegles(ActionEvent event) {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setResizable(false);
        dialog.setTitle("Regles du jeu - Le pendu");
        dialog.setContentText("Saisissez un caractere dans le champ, et entrer. Faites attention, a ne pas vous trompez trop de fois!");
        dialog.showAndWait();
    }

}

