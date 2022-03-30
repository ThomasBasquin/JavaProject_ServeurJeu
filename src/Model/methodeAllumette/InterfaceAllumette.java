package Model.methodeAllumette;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceAllumette extends Remote {
    boolean checkFini() throws RemoteException;

    int coupOrdinateur() throws RemoteException;

    boolean joueurVainqueur() throws RemoteException;

}
