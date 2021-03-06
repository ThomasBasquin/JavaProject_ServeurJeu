package Controler;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Model.methodeAllumette.ImplAllumette;
import Model.methodeAllumette.InterfaceAllumette;

import java.io.IOException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;


public class ControleurAllumette implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    ArrayList<ImageView> allAllumette = new ArrayList<>();

    @FXML
    private Label AllumetteEnlever;

    @FXML
    private ImageView allumette1;

    @FXML
    private ImageView allumette10;

    @FXML
    private ImageView allumette11;

    @FXML
    private ImageView allumette2;

    @FXML
    private ImageView allumette3;

    @FXML
    private ImageView allumette4;

    @FXML
    private ImageView allumette5;

    @FXML
    private ImageView allumette6;

    @FXML
    private ImageView allumette7;

    @FXML
    private ImageView allumette8;

    @FXML
    private ImageView allumette9;

    @FXML
    private Button button1;

    @FXML
    private Button btn2;

    @FXML
    private Label nbAllumetteJ;

    @FXML
    private Label nbAllumetteO;

    @FXML
    private Label nbAllumetteR;


    ImplAllumette allumette = new ImplAllumette();

    InterfaceAllumette jeu;

    public ControleurAllumette() throws RemoteException {
    }


    public void initializationPartie() throws IOException {
        Image image = new Image("./Vue/images/Allumette.png");
        allAllumette.add(allumette1);
        allAllumette.add(allumette2);
        allAllumette.add(allumette3);
        allAllumette.add(allumette4);
        allAllumette.add(allumette5);
        allAllumette.add(allumette6);
        allAllumette.add(allumette7);
        allAllumette.add(allumette8);
        allAllumette.add(allumette9);
        allAllumette.add(allumette10);
        allAllumette.add(allumette11);

        allumette1.setImage(image);
        allumette2.setImage(image);
        allumette3.setImage(image);
        allumette4.setImage(image);
        allumette5.setImage(image);
        allumette6.setImage(image);
        allumette7.setImage(image);
        allumette8.setImage(image);
        allumette9.setImage(image);
        allumette10.setImage(image);
        allumette11.setImage(image);

        btn2.setDisable(false);
        allumette.setNbAllumette(11);
        allumette.setordinateurNbAllumette(0);
        allumette.setjoueurNbAllumette(0);
        int coup = allumette.coupOrdinateur();
        if (coup == 1){
            coupOrdinateur();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        try {
            int port = 8000;
            jeu = (InterfaceAllumette) Naming.lookup("rmi://localhost:"+port+"/allumette"); //Recherche du serveur
            initializationPartie();
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }

    }

    public void setLabel(){
        nbAllumetteJ.setText(Integer.toString(allumette.getjoueurNbAllumette()));
        nbAllumetteO.setText(Integer.toString(allumette.getordinateurNbAllumette()));
        nbAllumetteR.setText(Integer.toString(allumette.getNbAllumette()));

    }
    public void checkFini() throws IOException {

        setLabel();

        if (allumette.checkFini()){
            if (allumette.joueurVainqueur()){
                Rejouer("Gagnee");
            }else{
                Rejouer("Perdu");
            }
        }
    }

    boolean resteUn(){
        if (allumette.getNbAllumette()==1){
            btn2.setDisable(true);
            return true;
        }else {
            return false;
        }
    }

    void enleverImage(int nb){

        for (int i = 1; i <= nb; i++) {
            allAllumette.get(allAllumette.size()-1).setImage(null);
            allAllumette.remove(allAllumette.size() - 1);
            allumette.setNbAllumette(allumette.getNbAllumette() - 1);
        }
    }

    private void Rejouer(String res) throws IOException {
        String message;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(res);
        if (res.contains("P")){
            message = "Desoler vous devez posseder un nombre impair d'allumette";
        }else{
            message ="Bravo vous avez gagner";
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
    void suppr1(ActionEvent event) throws IOException{
        resteUn();
        enleverImage(1);
        allumette.setjoueurNbAllumette(allumette.getjoueurNbAllumette()+1);
        checkFini();

        coupOrdinateur();
    }

    @FXML
    void suppr2(ActionEvent event) throws IOException{
        resteUn();
        enleverImage(2);
        allumette.setjoueurNbAllumette(allumette.getjoueurNbAllumette()+2);

        checkFini();
        coupOrdinateur();
    }

    void coupOrdinateur()throws IOException{

        int coup = allumette.coupOrdinateur();
        if(resteUn()){
           coup = 1;
        }
        allumette.setordinateurNbAllumette(allumette.getordinateurNbAllumette()+coup);
        enleverImage(coup);
        checkFini();

        AllumetteEnlever.setText(Integer.toString(coup));

    }

    public void openRegles(ActionEvent actionEvent) {
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setResizable(false);
        dialog.setTitle("Regles du jeu - Allumettes");
        dialog.setContentText("Pour gagner, il vous suffit de posseder un nombre impair d'allumettes.");
        dialog.showAndWait();
    }

    public void goToPageAccueil(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../Vue/VueAccueil.fxml"));
        scene = new Scene(root);
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void RejouerAllumette(ActionEvent actionEvent) throws IOException {
        initializationPartie();
    }
}
