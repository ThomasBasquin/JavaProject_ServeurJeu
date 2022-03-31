package main;

import Model.methodeAllumette.ImplAllumette;
import Model.methodePendu.ImplPendu;
import Model.methodeTicTacToe.implTicTacToe;


import java.rmi.*;
import java.rmi.registry.LocateRegistry;


public class Serveur {

    public static void main(String[] args){
        try {
            int port = 8000; //port
            LocateRegistry.createRegistry(port);

            //Jeu des allumettes
            ImplAllumette allumette = new ImplAllumette();
            Naming.rebind ("rmi://localhost:" + port + "/allumette", allumette);

            //Jeu du pendu
            ImplPendu pendu = new ImplPendu();
            Naming.rebind("rmi://localhost:" + port + "/pendu", pendu);

            //Jeu tic tac toe
            implTicTacToe TicTacToe = new implTicTacToe();
            Naming.rebind("rmi://localhost:" + port + "/TicTacToe", TicTacToe);

            System.out.println ("Jeu Server pret !");

        }catch (Exception e){
            System.out.println("Problème avec le serveur: " + e);
        }
    }
}