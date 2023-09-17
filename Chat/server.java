//JoaoGuilhermeIwoDeLaCosta 120461

package Chat;

import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.err.println("Usage: java server <port number>");
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
                sendStuffServer tSend = new sendStuffServer("Server", writer, keyboard);
                ReceiveStuff tReceive = new ReceiveStuff("Server", reader);
                while(true){

                        tSend.start();
                        tReceive.start();
                }
        }   catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

}
