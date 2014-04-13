import java.util.*;
public class CipherDemo{
public static void main(String[] args){
   Scanner sc=new Scanner(System.in);
   System.out.print("Please enter a String: ");
   String input=sc.nextLine();
  Encode test=new Encode(input);
   ArrayList encoded=new ArrayList<String>();
   encoded=test.getEncodedInput();
   System.out.println("Your encoded String: "+encoded.toString());
   Decode test1=new Decode();
   String output=test1.decodeThis(encoded.toString());
   System.out.println("Decoded String: "+output);
}
}