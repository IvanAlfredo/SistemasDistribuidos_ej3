/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_258;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Usuario
 */
public class Servidor_RMI_cadena extends UnicastRemoteObject implements Interfaz_RMI_cadena {
    Servidor_RMI_cadena() throws java.rmi.RemoteException{
	super();
    }
    @Override
    public String sumar(String cadena) throws RemoteException {
        int numero = 0;
        String texto = "";
        for (int i = 0; i <= cadena.length() - 1; i++) {
            char aux = cadena.charAt(i);

            if (Character.toString(aux).equals("[") || Character.toString(aux).equals("]") || Character.toString(aux).equals(",")) {
                texto += aux;
                if (Character.toString(aux).equals("]")) {
                    break;
                }
            } else {
                numero = Integer.parseInt(Character.toString(aux));
                numero += 5;
                texto += numero;
            }
        }
        return texto;
    }
    public static void main(String args[]) { 
        try{
            Registry registro = LocateRegistry.createRegistry(7777);
            registro.rebind("RemotoRMI", new Servidor_RMI_cadena());//Mantiene el servidor en escucha
            System.out.println("Servidor activo");
        }catch(RemoteException ex){
            System.out.println(ex.getMessage());
        }
    }
}
