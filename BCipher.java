import java.util.*;

public class BCipher{
   private String input;
   private final String use="%" ;
public BCipher(){
}
public void setInput(String i){
   input=i;
}
public ArrayList<String> compute(){
   Random rand=new Random();
   ArrayList<String> encoded=new ArrayList<String>();
   char[] temp=input.toCharArray();
   int [] z={44,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,173};
   for(int i=-1;i<temp.length;i++){
      boolean run=true;
      int errorcheck=0;
      int first1a=Encode.getRandomWithExclusion(rand,32,255,z);
      int first1b=Encode.getRandomWithExclusion(rand,32,255,z);
      char first2a=(char) first1a;
      char first2b=(char) first1b;
      String first3=""+first2a+first2b;
      int original;
      int fillnot=10;
      char character;
      if(i==-1){
      original= (char) 'B';
      }
      else{
         character = temp[i];
         original = (int) character;            
         fillnot=rand.nextInt(3);
      }   
      if(fillnot==0||fillnot==1||i==-1){
         while(run){
            errorcheck++;
            int a=Encode.getRandomWithExclusion(rand,32,255,z);
            int b=Encode.getRandomWithExclusion(rand,32,255,z);
            int c=Encode.getRandomWithExclusion(rand,32,255,z);
            int d=Encode.getRandomWithExclusion(rand,32,255,z);
            int e=Encode.getRandomWithExclusion(rand,32,255,z);
            if(((a+b+c+d+e)/10)+8==original){
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
            if(errorcheck>100000){
              System.out.print("Oops, something went wrong, averting a System Crash by ending program");
              System.exit(0);
            }
         }
      }
      else{
         String fill="";
         for(int h=0;h<8;h++){
           int y= Encode.getRandomWithExclusion(rand,32,255,z);     
            //makes sure that filler is not mistaken for actual characters, also might confuse code breakers as 
            //é is not part of standard ascii
            if(h==2 &&(((char) y)==('%'))){
               y= 235;
            }   
         fill+=(char)y;
         }
      encoded.add(fill);
      i--;
      }
   }
   return encoded;
}

public String decode(ArrayList<String> e){
   String output="";
   double dubOutput=0;
   int intOutput=0;
   char charOutput=' ';
   for(int i=1;i<e.size();i++){
      dubOutput=0;
      if(e.get(i).charAt(3)=='%'){
         String calcul=e.get(i).substring(4);
         char [] a=calcul.toCharArray();
         for(int k=0;k<a.length;k++){
            dubOutput+=a[k];
         }
         intOutput= (int) (dubOutput/10)+8;
         charOutput=(char) intOutput;
         output+=(""+charOutput);
      }
   }
   return output;
}
}

