import java.util.*;
public class test{

public static void main(String[] args){
Scanner sc=new Scanner(System.in);
String hold=sc.nextLine();
char [] a=hold.toCharArray();
int b=0;
for(int i=0;i<a.length;i++){
b+=(int)a[i];
System.out.print(b);
}
double x=b;
b=(int)(x/8.0)-10;
char y=(char)b;
System.out.print(y);
}
}
