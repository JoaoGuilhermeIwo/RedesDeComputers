//JoaoGuilhermeIwoDeLaCosta 120461

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
                        String strServer,strKB;
                        System.out.println("Conectado");
                        System.out.println("Pronto para enviar a primeira msg");

                        while(!(strKB = keyboard.readLine()).equals("Tchau.")){
                            //strKB = keyboard.readLine();
                            System.out.println("Client: " + strKB);
                            writer.println(strKB);
                            
                            strServer = reader.readLine();
                             System.out.println("Server: " + strServer);
                            if (strServer.equals("Tchau."))
                                break;

                        }break;
                }
        }   catch (IOException ex) {
            System.err.println("Não foi possível obter E/S para a conexão com " +
                hostname);
            System.exit(1);
        }

    }
}
