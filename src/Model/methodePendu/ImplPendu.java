package Model.methodePendu;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ImplPendu extends UnicastRemoteObject {

    ArrayList<String> listeMots;

    public ImplPendu() throws RemoteException {
        super();

        listeMots = new ArrayList<String>();
    }


}
