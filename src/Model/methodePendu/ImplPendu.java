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
    String mot = new String();
    ArrayList<Character> lettreTrouve = new ArrayList<>();
    boolean gagner;

    @Override
    public boolean isGagner() throws RemoteException{
        return gagner;
    }

    @Override
    public void setGagner(boolean gagner) throws RemoteException {
        this.gagner = gagner;
    }

    int faute;

    @Override
    public int getFaute() throws RemoteException {
        return faute;
    }

    @Override
    public void setFaute(int faute) throws RemoteException{
        this.faute = faute;
    }

    @Override
    public ArrayList<Character> getLettreTrouve() throws RemoteException{
        return lettreTrouve;
    }

    @Override
    public void setLettreTrouve(ArrayList<Character> lettreTrouve) throws RemoteException{
        this.lettreTrouve = lettreTrouve;
    }

    public ImplPendu() throws RemoteException {

        super();
        motChoisit = new ArrayList<String>();


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
        lettresDuMot = new ArrayList<Character>();
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
        String underscore = new String();
        for(int i = 0; i < motChoisit.get(0).length(); i++) {
            underscore = underscore + '_';
        }
        return underscore;
    }

    @Override
    public String affichageDuMot(char c) throws RemoteException {
        mot = "";
        boolean trouver = false;

        for (int j = 0; j < lettresDuMot.size(); j++) {
                mot +='_';
        }
        StringBuilder newMot = new StringBuilder(mot);
        for (int i = 0; i < lettresDuMot.size(); i++) {
            if (lettresDuMot.get(i) == c){
                lettreTrouve.add(c);
                newMot.setCharAt(i,c);
                trouver = true;
            }
            for (int j = 0; j < lettreTrouve.size(); j++) {
                if (lettresDuMot.get(i) == lettreTrouve.get(j)){
                    newMot.setCharAt(i ,lettreTrouve.get(j))  ;
                }
            }
        }

        setGagner(!newMot.toString().contains("_"));
        checkPerdu(trouver);
        return newMot.toString();
    }

     @Override
     public boolean checkPerdu(boolean trouver) throws RemoteException{
        if (!trouver){
            if (this.getFaute() == 11){
                return true;
            }else{
                this.setFaute(this.getFaute()+1);
                return false;
            }
        }
        return false;
    }




}
