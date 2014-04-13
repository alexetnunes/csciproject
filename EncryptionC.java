import java.io.*;
import java.net.*;

public class EncryptionC {
  public static void main(String[] args) {

    Socket clientSocket = null;
    DataInputStream in = null;
    PrintStream out = null;
    DataInputStream inputLine = null;

    //open a socket on port 6001
        try {
      clientSocket = new Socket("localhost", 6001);
      out = new PrintStream(clientSocket.getOutputStream());
      in = new DataInputStream(clientSocket.getInputStream());
      inputLine = new DataInputStream(new BufferedInputStream(System.in));
    } catch (UnknownHostException e) {
      System.err.println("unknown server");
    } catch (IOException e) {
      System.err.println("Connection to server failed");
    }


    if (clientSocket != null && out != null && in != null) {
      try {

        //keep reading data until * 
        System.out.println("The client started. Type any text. To quit it type '*'.");
        String responseLine;
        out.println(inputLine.readLine());
        while ((responseLine = in.readLine()) != null) {
          System.out.println(responseLine);
          if (responseLine.indexOf("*") != -1) {
            break;
          }
          out.println(inputLine.readLine());
        }

        //close input, output and the socket       
        out.close();
        in.close();
        clientSocket.close();
      } catch (UnknownHostException e) {
        System.err.println("Trying to connect to unknown server: " + e);
      } catch (IOException e) {
        System.err.println("IOException:  " + e);
      }
    }
  }
}