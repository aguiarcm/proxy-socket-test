package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    //https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/networking/sockets/examples/KKMultiServerThread.java
    //http://www.java2s.com/Code/Java/Network-Protocol/AverysimpleWebserverWhenitreceivesaHTTPrequestitsendstherequestbackasthereply.htm
    public static void main(String[] args) {
        try {

            int port = Integer.parseInt(args[0]);

            ServerSocket ss = new ServerSocket(port);

            for (; ; ) {
                Socket client = ss.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream());

                out.print("\r\n"); // End of headers

                String line;
                while ((line = in.readLine()) != null) {
                    if (line.length() == 0)
                        break;
                    System.out.println(line + "\r\n");
                }

                out.close();
                in.close();
                client.close();
            }
        }
          catch (Exception e) {
            System.err.println(e);
        }
    }
}

