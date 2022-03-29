package methode.methodeAllumette;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplAllumette extends UnicastRemoteObject implements InterfaceAllumette, Serializable {
    private int nbAllumette;
    private int idPartie;
    private boolean joueur;
    private boolean ordinateur;

    public ImplAllumette() throws RemoteException {
        this.nbAllumette = 11;
        this.joueur = false;
        this.ordinateur = false;
    }

    public int getNbAllumette() {
        return nbAllumette;
    }

    public void setNbAllumette(int nbAllumette) {
        this.nbAllumette = nbAllumette;
    }

    public int getIdPartie() {
        return idPartie;
    }

    public void setIdPartie(int idPartie) {
        this.idPartie = idPartie;
    }

    public boolean getJoueur() {
        return joueur;
    }

    public void setJoueur(boolean joueur) {
        this.joueur = joueur;
    }

    public boolean getOrdinateur() {
        return ordinateur;
    }

    public void setOrdinateur(boolean ordinateur) {
        this.ordinateur = ordinateur;
    }



    @Override
    public void Tourde(boolean tour1) throws RemoteException {


        if (tour1){
            if (this.coupOrdinateur() == 1){
                this.setOrdinateur(true);
            }else{
                this.setJoueur(true);
            }
        }else {
            System.out.println("tour avant J " + this.getJoueur());
            System.out.println("tour avant O " + this.getOrdinateur());
            if (this.getOrdinateur() == false) {
                this.setJoueur(false);
                this.setOrdinateur(true);

            } else {
                this.setJoueur(true);
                this.setOrdinateur(false);
            }
            System.out.println("tour apres J " + this.getJoueur());
            System.out.println("tour apres O " + this.getOrdinateur());
        }
    }


    @Override
    public boolean checkFini(int nbAllumette) throws RemoteException {
        System.out.println(this.getNbAllumette());
        if (this.getNbAllumette()-1 <= 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean joueurVainqueur() throws RemoteException{
        if (nbAllumette == 1 && this.getJoueur()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int coupOrdinateur() throws RemoteException {
        return 1 + (int)(Math.random() * ((2 - 1) + 1));
    }
}
