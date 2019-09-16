/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_258;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Usuario
 */
public interface Interfaz_RMI_cadena extends Remote {
    public String sumar(String cadena) throws RemoteException;
    
}
