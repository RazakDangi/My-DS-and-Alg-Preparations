package edxAlgJava;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class APlusB {
  public static void main(String[] args) {
  
  int n=163482374;
  String s=String.valueOf(n);
  int size=String.valueOf(n).length();
 
  int[] input=Stream.of(s.split("")).mapToInt(Integer::parseInt).toArray();
 
int count=0;
   StringBuilder str=new StringBuilder(size+1);
   for(int i=0,j=0;i<size || j<size ;j++,i++)
   {
	   
	   str.append(input[i]);count++;
	   if(count==size) break;
	   str.append(input[size-j-1]);count++;
	   if(count==size)break;

	 
   }
 
 System.out.println(str.toString());
}
}