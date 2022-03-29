package main;

import Model.methode.methodeAllumette.ImplAllumette;


import java.rmi.*;
import java.rmi.registry.LocateRegistry;


public class Serveur {

    public static void main(String[] args){
        try {
            int port = 8000;

            LocateRegistry.createRegistry(port);
            Naming.rebind ("rmi://localhost:"+port+"/allumette", new ImplAllumette());
            System.out.println ("Jeu Server pret !");

        }catch (Exception e){
            System.out.println("Problème avec le serveur:"+e);
        }
    }
}