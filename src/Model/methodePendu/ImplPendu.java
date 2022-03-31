package Model.methodePendu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ImplPendu extends UnicastRemoteObject implements InterfacePendu, Serializable {

    ArrayList<String> dictionnaire;
    ArrayList<String> motChoisit;
    ArrayList<Character> lettresDuMot;

    public ImplPendu() throws RemoteException {
        super();
        motChoisit = new ArrayList<String>();
        lettresDuMot = new ArrayList<Character>();

        //Crée une arrayList de mot, qui stock toutes la liste des mots du fichier dictionnaire
        dictionnaire = new ArrayList<String>();
        BufferedReader fichier;
        String ligne;
        try {
            fichier = new BufferedReader(new FileReader("src/Model/methode/tools/dictionnaire.txt"));

            while((ligne= fichier.readLine()) != null) {
                dictionnaire.add(ligne.replace('\n',' '));
            }

            fichier.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(dictionnaire);

    }

    @Override
    public void setMot() throws RemoteException {

    }

    @Override
    public void setLettresDuMot() throws RemoteException {

    }

    @Override
    public boolean verifReponse(char c) throws RemoteException {
        return false;
    }

    @Override
    public String affichageDuMotUnderscore() throws RemoteException {
        return null;
    }

    @Override
    public String affichageDuMot(char c) throws RemoteException {
        return null;
    }
}
