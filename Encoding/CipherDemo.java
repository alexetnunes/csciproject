import java.util.*;
public class CipherDemo{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
System.out.print("Please enter a String: ");
String input=sc.nextLine();
System.out.print("Please enter your cipher: ");
String c=sc.nextLine();
Encode test=new Encode(input, c);
ArrayList encoded=new ArrayList<String>();
encoded=test.getEncodedInput();
System.out.print("Your encoded String: "+encoded.toString());
}
}