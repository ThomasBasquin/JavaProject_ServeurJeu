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

    }

    @Override
    public void setMot() throws RemoteException {
        motChoisit.add(0,dictionnaire.get((int) (Math.random() * dictionnaire.size())));
    }

    @Override
    public String getMot() throws RemoteException {
        return motChoisit.get(0);
    }

    @Override
    public void setLettresDuMot() throws RemoteException {
        for (int i = 0; i < motChoisit.get(0).length(); i++) {
            lettresDuMot.add(motChoisit.get(0).charAt(i));
        }
    }

    @Override
    public ArrayList<Character> getLettresDuMot() throws RemoteException {
        return lettresDuMot;
    }

    @Override
    public boolean verifReponse(char c) throws RemoteException {
        return false;
    }

    @Override
    public String affichageDuMotUnderscore() throws RemoteException {
        String mot = new String();
        for(int i = 0; i < motChoisit.get(0).length(); i++) {
            mot = mot + '_';
        }
        return mot;
    }

    @Override
    public String affichageDuMot(char c) throws RemoteException {
        String mot = new String();

        for(int i = 0; i < lettresDuMot.size(); i++) {
            if(lettresDuMot.get(i) == c) {
                mot = mot + c;
            } else if (lettresDuMot.get(i) != c) {
                mot = mot + '_';
            }
        }
        return mot;
    }
}
