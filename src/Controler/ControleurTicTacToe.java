package Controler;

import Model.methodeAllumette.InterfaceAllumette;
import Model.methodeTicTacToe.InterfaceTicTacToe;
import Model.methodeTicTacToe.implTicTacToe;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControleurTicTacToe implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private InterfaceTicTacToe jeu;
    private implTicTacToe TTT = new implTicTacToe();
    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button buttonQuitter;

    @FXML
    private Button buttonRegles;

    @FXML
    private Button buttonRestart;



    public ControleurTicTacToe() throws RemoteException {
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
        dialog.setTitle("Regles du jeu - Tic Tac Toe");
        dialog.setContentText("");
        dialog.showAndWait();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            int port = 8000;
            jeu = (InterfaceTicTacToe) Naming.lookup("rmi://localhost:"+port+"/TicTacToe");
            initializationPartie();//Recherche du serveur
            if (TTT.premierCoup()==1){
                tourOrdinateur();
            }
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }

    }

    void initializationPartie() throws RemoteException {
        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);
        btn5.setDisable(false);
        btn6.setDisable(false);
        btn7.setDisable(false);
        btn8.setDisable(false);
        btn9.setDisable(false);

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        TTT = new implTicTacToe();
    };

    @FXML
    void RejouerTicTacToe(ActionEvent event) throws RemoteException {
        initializationPartie();
    }

    private void Rejouer(int res) throws IOException {
        String message;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Resultats");
        if (res == 1){
            message = "Desoler vous avez perdu";
        }else if (res == 2){
            message ="Bravo vous avez gagner";
        }else{
            message = "Egalite";
        }
        alert.setHeaderText(message);
        alert.setContentText("Voulez-vous rejouer ?");

        // option != null.
        Optional<ButtonType> option = alert.showAndWait();

        if (option.get() == ButtonType.OK) {
            initializationPartie();
        } else if (option.get() == ButtonType.CANCEL) {
            Stage stage =(Stage) btn2.getScene().getWindow();
            stage.close();
        }

    }

    void tourOrdinateur() throws IOException {
        int coup =TTT.ajoutCoupOrdinateur();

        switch (coup){
            case 1:
                btn1.setText("X");
                btn1.setDisable(true);

                break;
            case 2:
                btn2.setText("X");
                btn2.setDisable(true);
                break;
            case 3:
                btn3.setText("X");
                btn3.setDisable(true);
                break;
            case 4:
                btn4.setText("X");
                btn4.setDisable(true);
                break;
            case 5:
                btn5.setText("X");
                btn5.setDisable(true);
                break;
            case 6:
                btn6.setText("X");
                btn6.setDisable(true);
                break;
            case 7:
                btn7.setText("X");
                btn7.setDisable(true);
                break;
            case 8:
                btn8.setText("X");
                btn8.setDisable(true);
                break;
            case 9:
                btn9.setText("X");
                btn9.setDisable(true);
                break;
        }
        Vainqueur();
    }

    void Vainqueur() throws IOException {
        System.out.println(TTT.getTabRond());
        if (TTT.checkVainqueurCroix()== true){
            this.Rejouer(1);
        }else if(TTT.checkVainqueurRond() == true){
            this.Rejouer(2);
        }else if(TTT.getTabCoupJouer().size() == 9){
            this.Rejouer(3);
        }
    }
    @FXML
    void boutonCliquer1() throws IOException {
        TTT.getTabRond().add(11);
        TTT.getTabCoupJouer().add(1);
        btn1.setDisable(true);
        btn1.setText("0");
        Vainqueur();
        tourOrdinateur();
    }

    @FXML
    void boutonCliquer2() throws IOException {
        TTT.getTabRond().add(12);
        TTT.getTabCoupJouer().add(2);
        btn2.setDisable(true);
        btn2.setText("O");
        Vainqueur();
        tourOrdinateur();
    }

    @FXML
    void boutonCliquer3() throws IOException {
        TTT.getTabRond().add(13);
        TTT.getTabCoupJouer().add(3);
        btn3.setDisable(true);
        btn3.setText("O");
        Vainqueur();
        tourOrdinateur();
    }

    @FXML
    void boutonCliquer4() throws IOException {
        TTT.getTabRond().add(21);
        TTT.getTabCoupJouer().add(4);
        btn4.setDisable(true);
        btn4.setText("O");
        Vainqueur();
        tourOrdinateur();
    }

    @FXML
    void boutonCliquer5() throws IOException {
        TTT.getTabRond().add(22);
        TTT.getTabCoupJouer().add(5);
        btn5.setDisable(true);
        btn5.setText("O");
        Vainqueur();
        tourOrdinateur();
    }

    @FXML
    void boutonCliquer6() throws IOException {
        TTT.getTabRond().add(23);
        TTT.getTabCoupJouer().add(6);
        btn6.setDisable(true);
        btn6.setText("O");
        Vainqueur();
        tourOrdinateur();
    }

    @FXML
    void boutonCliquer7() throws IOException {
        TTT.getTabRond().add(31);
        TTT.getTabCoupJouer().add(7);
        btn7.setDisable(true);
        btn7.setText("O");
        Vainqueur();
        tourOrdinateur();
    }

    @FXML
    void boutonCliquer8() throws IOException {
        TTT.getTabRond().add(32);
        TTT.getTabCoupJouer().add(8);
        btn8.setDisable(true);
        btn8.setText("O");
        Vainqueur();
        tourOrdinateur();
    }

    @FXML
    void boutonCliquer9() throws IOException {
        TTT.getTabRond().add(33);
        TTT.getTabCoupJouer().add(9);
        btn9.setDisable(true);
        btn9.setText("O");
        Vainqueur();
        tourOrdinateur();
    }
}
