package Model.methodeTicTacToe;

import java.io.Serializable;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class implTicTacToe extends UnicastRemoteObject implements InterfaceTicTacToe, Serializable {

    private ArrayList<Integer> tabCroix;
    private ArrayList<Integer> tabRond;
    private ArrayList<Integer> tabCoupJouer;
    private char Croix;
    private char Rond;

    public char getCroix() {
        return Croix;
    }

    public void setCroix(char croix) {
        Croix = croix;
    }

    public char getRond() {
        return Rond;
    }

    public void setRond(char rond) {
        Rond = rond;
    }

    public implTicTacToe() throws RemoteException {
        super();
        this.tabCroix = new ArrayList<>();
        this.tabRond = new ArrayList<>();
        this.tabCoupJouer =new ArrayList<>();
        this.Croix = ' ';
        this.Rond = ' ';
    }

    public ArrayList<Integer> getTabCoupJouer() {
        return tabCoupJouer;
    }

    public void setTabCoupJouer(ArrayList<Integer> tabCoupJouer) {
        this.tabCoupJouer = tabCoupJouer;
    }

    public ArrayList<Integer> getTabCroix() {
        return tabCroix;
    }

    public void setTabCroix(ArrayList<Integer> tabCroix) {
        this.tabCroix = tabCroix;
    }

    public ArrayList<Integer> getTabRond() {
        return tabRond;
    }

    public void setTabRond(ArrayList<Integer> tabRond) {
        this.tabRond = tabRond;
    }

    @Override
    public void ajoutTableCroix(int nb) throws RemoteException {
        this.tabCroix.add(nb);
    }

    @Override
    public void ajoutTableRond(int nb) throws RemoteException {
        this.tabRond.add(nb);
    }

    public boolean checkVainqueurRond() throws RemoteException{

        for (int i = 10; i <= 30; i+=10) {
            int troisRond = 0;
            for (int j = 1; j <= 3 ; j++){

                if (this.tabRond.contains(i+j)){
                   troisRond ++;
                   if (troisRond == 3){
                       return true;
                   }
                }
            }
        }

        for (int i = 11; i <= 13; i++) {
            int troisRond = 0;
            for (int j = 0; j <= 20 ; j+=10){
                if (this.tabRond.contains(i+j)){
                    troisRond ++;
                    if (troisRond == 3){
                        return true;
                    }
                }
            }
        }
        for (int j = 0; j < 1; j++) {
            int troisRond = 0;
            for (int i = 11; i <=33 ; i+=11) {
                if (this.tabRond.contains(i)){
                    troisRond ++;
                    if (troisRond == 3){
                        return true;
                    }
                }
            }
        }


        for (int j = 0; j < 1; j++) {
            int troisRond = 0;
            for (int i = 13; i <= 31; i+=9) {
                if (this.tabRond.contains(i)) {
                    troisRond++;
                    if (troisRond == 3) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean checkVainqueurCroix() throws RemoteException{

        for (int i = 10; i <= 30; i+=10) {
            int troisRond = 0;
            for (int j = 1; j <= 3 ; j++){

                if (this.tabCroix.contains(i+j)){
                    troisRond ++;
                    if (troisRond == 3){
                        return true;
                    }
                }
            }
        }
        for (int i = 11; i <= 13; i++) {
            int troisRond = 0;
            for (int j = 0; j <= 20 ; j+=10){
                if (this.tabCroix.contains(i+j)){
                    troisRond ++;
                    if (troisRond == 3){
                        return true;
                    }
                }
            }
        }

        for (int i = 11; i <=33 ; i+=11) {
            int troisRond = 0;
            if (this.tabRond.contains(i)){
                troisRond ++;
                if (troisRond == 3){
                    return true;
                }
            }
        }

        for (int i = 13; i <= 31; i+=9) {
            int troisRond = 0;
            if (this.tabRond.contains(i)) {
                troisRond++;
                if (troisRond == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public int coupOrdinateur(){
        int coup =0;
        do {
            coup = 1 + (int)(Math.random() * 9);
        }while(this.tabCoupJouer.contains(coup));


        return coup;
    }

    public int premierCoup(){
        return 1 + (int)(Math.random() * 2);
    }
     public int ajoutCoupOrdinateur(){
        int coup = coupOrdinateur();
         ;
        switch (coup){
            case 1:
                this.getTabCoupJouer().add(1);
                this.getTabCroix().add(11);
                break;
            case 2:
                this.getTabCoupJouer().add(2);
                this.getTabCroix().add(12);
                break;
            case 3:
                this.getTabCoupJouer().add(3);
                this.getTabCroix().add(13);
                break;
            case 4:
                this.getTabCoupJouer().add(4);
                this.getTabCroix().add(21);
                break;
            case 5:
                this.getTabCoupJouer().add(5);
                this.getTabCroix().add(22);
                break;
            case 6:
                this.getTabCoupJouer().add(6);
                this.getTabCroix().add(23);
                break;
            case 7:
                this.getTabCoupJouer().add(7);
                this.getTabCroix().add(31);
                break;
            case 8:
                this.getTabCoupJouer().add(8);
                this.getTabCroix().add(32);
                break;
            case 9:
                this.getTabCoupJouer().add(9);
                this.getTabCroix().add(33);
                break;
        }
        return coup ;
     }
}
