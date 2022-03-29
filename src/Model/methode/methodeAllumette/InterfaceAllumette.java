package Model.methode.methodeAllumette;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceAllumette extends Remote {
    boolean checkFini(int nbAlumette)throws RemoteException;
    int coupOrdinateur()throws RemoteException;
    void Tourde(boolean tour1) throws RemoteException;
    boolean joueurVainqueur()throws RemoteException;

}
