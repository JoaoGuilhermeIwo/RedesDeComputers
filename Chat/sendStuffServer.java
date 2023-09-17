package Chat;

import java.io.*;
//import java.net.*;

public class sendStuffServer extends Thread{
    PrintWriter writer;
    BufferedReader keyboard;
    String Who;
    
    public sendStuffServer(String Who, PrintWriter writer, BufferedReader keyboard){
        this.Who = Who;
        this.writer = writer;
        this.keyboard = keyboard;
    }

    @Override
    public void run(){
        String strKB;
        try {
            while(!(strKB = keyboard.readLine()).equals("Tchau.")){
                System.out.println(Who + ":" + strKB);
                writer.println(strKB);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}