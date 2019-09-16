/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_258;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Usuario
 */
public class Cliente_RMI_cadena {

    public static void main(String args[]) {
        Cliente_RMI_cadena cliente = new Cliente_RMI_cadena();
        cliente.conectServer();
    }
    private void conectServer(){
        try{
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 7777);
            Interfaz_RMI_cadena interfaz = (Interfaz_RMI_cadena)registro.lookup("RemotoRMI");//Busca elobjeto remoto en el RMI  de la maquina remoto
            String cadena = "[4,5,6,7,8]";
            cadena = interfaz.sumar(cadena);
            System.out.println(""+cadena);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
