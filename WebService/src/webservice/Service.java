package webservice;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Service {

    private static final String serverIP = "192.168.0.99";
    private static final int serverPort = 80;
    
    public static void main(String argv[]) throws Exception {
        
        String msgToServer;
        String msgFromServer;
        
        Socket clientSocket = new Socket(serverIP, serverPort);
	System.out.println("Conectando em: " + serverIP + " na porta: " + serverPort);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        msgToServer = "Bem Vindo ao Arduino Service!";
	outToServer.writeBytes(msgToServer+'\n');
	System.out.println("Enviando para o Arduino: " + msgToServer);
	msgFromServer = inFromServer.readLine();
        System.out.println("Resposta do Arduino: " + msgFromServer);
        clientSocket.close();
    }
}
