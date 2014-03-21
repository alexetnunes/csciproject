import java.util.*;

public class Encode{
private String input;
private String cipher;
private ArrayList<String> encodedInput;
public Encode(String input, String c){
this.input=input;
cipher=c;
encodedInput=sendToCipher();
}
private ArrayList<String> sendToCipher(){
ACipher a1=new ACipher();
BCipher b1=new BCipher();
CCipher c1=new CCipher();
DCipher d1=new DCipher();
ECipher e1=new ECipher();
ArrayList<String> export=new ArrayList<String>();
if(cipher.equals("a")){
a1.setInput(input);
export=a1.compute();
}
else if(cipher.equals("b")){
b1.setInput(input);
export=b1.compute();
}
else if(cipher.equals("c")){
c1.setInput(input);
export=c1.compute();
}
else if(cipher.equals("d")){
d1.setInput(input);
export=d1.compute();
}
else if(cipher.equals("e")){
e1.setInput(input);
export=e1.compute();
}
else{
System.out.println("Invalid Cipher Name");
}
//generate keys here
return export;
}
public ArrayList<String> getEncodedInput(){
return encodedInput; 
}
} 