import java.util.*;

public class ACipher{
private String input;
private final String use="c" ;
public ACipher(){
}
public void setInput(String i){
input=i;
}
public ArrayList<String> compute(){
   Random rand=new Random();
   ArrayList<String> encoded=new ArrayList<String>();
   char[] temp=input.toCharArray();
   encoded.add("Temp");
   for(int i=0;i<temp.length;i++){
      char character = temp[i];
      int original = (int) character; 
      int first1=rand.nextInt(95)+32;
      char first2=(char) first1;
      String first3=""+first2;
      boolean run=true;
      int errorcheck=0;
      int fillnot=rand.nextInt(2);
      if(fillnot==0){
         while(run){
            errorcheck++;
            int a=rand.nextInt(95)+32;
            int b=rand.nextInt(95)+32;
            int c=rand.nextInt(95)+32;
            int d=rand.nextInt(95)+32;
            int e=rand.nextInt(95)+32;
            if((a+b+c+d+e)/5.0+8==original){
               run=false;
               character=(char)a;
               String forAdding=""+character;
               character=(char)b;
               forAdding+=""+character;
               character=(char)c;
               forAdding+=""+character;
               character=(char)d;
               forAdding+=""+character;
               character=(char)e;
               forAdding+=""+character;
               encoded.add(first3+use+forAdding);
               errorcheck=0;
            }
            if(errorcheck>10000){
              System.out.print("Oops, something went wrong, averting a System Crash by ending program");
              System.exit(0);
            }
         }
      }
      else{
         String fill="";
         for(int z=0;z<8;z++){
           int y= (rand.nextInt(95)+32);     
            //makes sure that filler is not mistaken for actual characters, also might confuse code breakers as 
            //é is not part of standard ascii
            if(z==2 &&!(((char) y)==('c'))){
               y= (int) 'é';
            }   
         fill+=(char)y;
         }
      encoded.add(fill);
      i--;
      }
   }
   return encoded;
}
}