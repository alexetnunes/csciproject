import java.util.*;
public class Decode{
private String input;
private String output;
private ArrayList<String> prepInput;
private char cipher;
public Decode(){
prepInput=new ArrayList<String>();
}
//Debugging tools will be removed in final version
public String getOutput(){
   return output;
}
public String getInput(){
   return input;
}
public ArrayList<String> getPrepInput(){
   return prepInput;
}
public void setOutput(String o){
   output=o;
}
public void setPrepInput(ArrayList<String> p){
   prepInput=p;
}
public void setInput(String i){
input=i;
}
//not to be removed in final version
public String decodeThis(String i){
input=i;
input=input.substring(1,input.length()-1);
String [] inputArray=input.split(",");
for(int h=0;h<inputArray.length;h++){
prepInput.add(inputArray[h]);
}
cipher=whatCipher();
if(cipher==('A')){
ACipher ciphera=new ACipher();
output=ciphera.decode(prepInput);
}
return output;
}
private char whatCipher(){
   double b=0;
   int h=0;
   if (prepInput.size()>0){
      String calc=prepInput.get(0);
      calc=calc.substring(3,8);
      char [] a=calc.toCharArray();
      for(int i=0;i<a.length;i++){
         b+=a[i];
      }
      h=(int)(b/8.0-10);
      
   }
   return (char) h;
   
}
}