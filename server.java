//JoaoGuilhermeIwoDeLaCosta 120461

import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.err.println("Usage: java KnockKnockServer <port number>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);

        try(ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();

            InputStream input = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader( new InputStreamReader(input));

            OutputStream output = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            ) {
                BufferedReader keyboard = new BufferedReader( new InputStreamReader(System.in));
                while(true){
                        String strClient,strKB;

                        while((strClient = reader.readLine()) != null){
                            System.out.println("Client: " + strClient);
                            if (strClient.equals("Tchau."))
                                break;

                            strKB = keyboard.readLine();
                            System.out.println("Server: " + strKB);
                            writer.println(strKB);
                        }break;
                }
        }   catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

}
