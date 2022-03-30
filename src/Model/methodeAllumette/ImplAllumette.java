package Model.methodeAllumette;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplAllumette extends UnicastRemoteObject implements InterfaceAllumette, Serializable {

    private int nbAllumette = 11;
    private int joueurNbAllumette = 0;
    private int ordinateurNbAllumette = 0;

    public ImplAllumette() throws RemoteException {
        this.nbAllumette = 11;
        this.joueurNbAllumette = 0;
        this.ordinateurNbAllumette = 0;
    }

    public int getNbAllumette() {
        return this.nbAllumette;
    }

    public void setNbAllumette(int nbAllumette) {
        this.nbAllumette = nbAllumette;
    }

    public int getjoueurNbAllumette() {
        return this.joueurNbAllumette;
    }

    public void setjoueurNbAllumette(int joueurNbAllumette) {
        this.joueurNbAllumette = joueurNbAllumette;
    }

    public int getordinateurNbAllumette() {
        return this.ordinateurNbAllumette;
    }

    public void setordinateurNbAllumette(int ordinateurNbAllumette) {
        this.ordinateurNbAllumette = ordinateurNbAllumette;
    }

    public boolean checkFini() throws RemoteException {
        return this.getNbAllumette() == 0;
    }

    public int coupOrdinateur() throws RemoteException {
        return 1 + (int)(Math.random() * 2.0D);
    }

    public boolean joueurVainqueur() throws RemoteException {
        return this.getjoueurNbAllumette() % 2 != 0;
    }
}
