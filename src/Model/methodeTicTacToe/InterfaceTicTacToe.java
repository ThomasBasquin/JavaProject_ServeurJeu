package Model.methodeTicTacToe;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceTicTacToe extends Remote {
    void ajoutTableCroix (int nb) throws RemoteException;
    void ajoutTableRond (int nb) throws RemoteException;
}
