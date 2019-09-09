/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sis_258;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Usuario
 */
public class Servidor_invertir_cadena {
    public static void main (String args[]) {
    Servidor_invertir_cadena serv = new Servidor_invertir_cadena();
    try {
      System.out.println("Iniciado el servidor");
      DatagramSocket socketUDP = new DatagramSocket(6789);
      byte[] bufer = new byte[1000];

      while (true) {
        // Construimos el DatagramPacket para recibir peticiones
        DatagramPacket peticion =
          new DatagramPacket(bufer, bufer.length);

        // Leemos una petición del DatagramSocket
        socketUDP.receive(peticion);
        
        String mensaje = new String(peticion.getData());
        System.out.println(mensaje);
        
        String mensaje1 = serv.invertir(mensaje);
        bufer = mensaje1.getBytes();
        System.out.print("Datagrama recibido del host: " +
                           peticion.getAddress());
        System.out.println(" desde el puerto remoto: " +
                           peticion.getPort());

        // Construimos el DatagramPacket para enviar la respuesta
        DatagramPacket respuesta =
          new DatagramPacket(bufer, bufer.length, peticion.getAddress(), peticion.getPort());

        // Enviamos la respuesta, que es un eco
        socketUDP.send(respuesta);
      }

    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }
    public String invertir(String cadena){
        String invertida="";
        for(int i=cadena.length()-1; i>=0; i--){
            String aux = Character.toString(cadena.charAt(i));
            invertida+=aux;
        }
        return invertida;
    }
}
