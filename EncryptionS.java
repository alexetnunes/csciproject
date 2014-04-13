import java.io.*;
import java.net.*;

public class EncryptionS {
  public static void main(String args[]) {

    ServerSocket echoServer = null;
    String line;
    DataInputStream in;
    PrintStream out;
    Socket clientSocket = null;

    
    try {
      echoServer = new ServerSocket(6001);
    } catch (IOException e) {
      System.out.println(e);
    }

    //create serversocket to wait for connections
     System.out.println("The server started. To stop it press <CTRL><C>.");
    try {
      clientSocket = echoServer.accept();
      in = new DataInputStream(clientSocket.getInputStream());
      out = new PrintStream(clientSocket.getOutputStream());

      //While new data is being sent return to user
      while (true) {
        line = in.readLine();
        out.println("From server: " + line);
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }
}
