//JoaoGuilhermeIwoDeLaCosta 120461

package Chat;

import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException{
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        try(
            Socket serverSocket = new Socket(hostname, port);
            PrintWriter writer = new PrintWriter( serverSocket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader( new InputStreamReader(serverSocket.getInputStream()));
        ){
                BufferedReader keyboard = new BufferedReader( new InputStreamReader(System.in));
                //DataOutputStream DOS = new DataOutputStream(serverSocket.getOutputStream());
                while(true){
                    
                        sendStuffServer tSend = new sendStuffServer("Client", writer, keyboard);
                        ReceiveStuff tReceive = new ReceiveStuff("Client", reader);
                        System.out.println("Conectado");
                        System.out.println("Pronto para enviar a primeira msg");

                        tSend.start();
                        tReceive.start();
                }
        }   catch (IOException ex) {
            System.err.println("Não foi possível obter E/S para a conexão com " +
                hostname);
            System.exit(1);
        }

    }
}
