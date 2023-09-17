package Chat;

import java.io.*;


public class ReceiveStuff extends Thread{
    BufferedReader reader;
    String Who;
    
    public ReceiveStuff(String Who, BufferedReader reader){
        this.Who = Who;
        this.reader = reader;
    }


    @Override
    public void run(){
        String strClient;
        
        try {
            while((strClient = reader.readLine()) != null){
                System.out.println("Client: " + strClient);
                if (strClient.equals("Tchau."))
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
