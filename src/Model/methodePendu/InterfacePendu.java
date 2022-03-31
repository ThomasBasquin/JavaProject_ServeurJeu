package Model.methodePendu;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Déclaration des fonctions d'ImplPendu
public interface InterfacePendu extends Remote {
    void setMot() throws RemoteException;
    void setLettresDuMot() throws RemoteException;
    boolean verifReponse(char c) throws RemoteException;
    String affichageDuMotUnderscore() throws RemoteException;
    String affichageDuMot(char c) throws RemoteException;
}
