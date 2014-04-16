import java.util.*;

public class Encode{
   private String input;
   private ArrayList<String> encodedInput;
public Encode(String input){
   this.input=input;
   encodedInput=sendToCipher();
}

//mutator method
public void encodeThis(String d){
	input=d;
	encodedInput=sendToCipher();
}

private ArrayList<String> sendToCipher(){
   ACipher a1=new ACipher();
   BCipher b1=new BCipher();
   CCipher c1=new CCipher();


   ArrayList<String> export=new ArrayList<String>();
   Random rand=new Random();
   int ciph=rand.nextInt(3);

   if(ciph==0){
      a1.setInput(input);
      export=a1.compute();
   }
   else if(ciph==1){
      b1.setInput(input);
      export=b1.compute();
   }
   else if(ciph==2){
      c1.setInput(input);
      export=c1.compute();
   }
        //generate keys here
   return export;
}
public ArrayList<String> getEncodedInput(){
   return encodedInput; 
}
/*I found this code on the internet while I was trying to figure out how to 
exclude 127 from the randomized numbers without making my code a nigthmare.
Here is my source.
 url="http://stackoverflow.com/questions/6443176/how-can-i-generate-a-random-number-within-a-range-but-exclude-some"
 */  
public static int getRandomWithExclusion(Random rand, int start, int end, int... exclude) {
    int random = start + rand.nextInt(end - start + 1 - exclude.length);
    for (int ex : exclude) {
        if (random < ex) {
            break;
        }
        random++;
    }
    return random;
}
} 