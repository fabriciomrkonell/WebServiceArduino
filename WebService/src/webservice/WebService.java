package webservice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Fabrício Ronchi
 */

public class WebService {
    
    public static void main(String[] args) throws IOException{        
        
        Socket client = new Socket("192.168.0.99", 80);   
                                                                                                          
        //Receber dados
        DataInputStream in = new DataInputStream(client.getInputStream());

        //Enviar dados
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        
        out.writeBytes("OI");
        
        //Recebendo de uma String
        String s = in.readUTF(); 
        
        //Enviando uma String
        out.writeBytes("Obrigado!");     
        
        //Imprime a String recebida
        System.out.println(s);      

        //Fecha os canais de entrada e saída.
        in.close();
        out.close();
        
        //Fecha o Socket
        client.close();            
        
    }          
}   
