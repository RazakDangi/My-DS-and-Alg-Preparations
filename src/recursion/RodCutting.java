package recursion;

public class RodCutting {

	 /* Returns the best obtainable price for a rod of length 
    n and price[] as prices of different pieces */
 static int cutRod(int price[], int n,int x,int maxtrace) 
 { 
     if (n <= 0) 
         {System.out.println("iteran i="+x+" push and pop f(0)"+"return max of(premaxv,price[i]+maxv,)="+maxtrace+","+ price[x]+"+"+0);return 0;} 
     int max_val = -1; 
     System.out.println("\n push f("+n+") "+"i="+x+" p[i]="+price[x]);
     // Recursively cut the rod in different pieces and 
     // compare different configurations 
     System.out.println("now iteration i="+(x)+"  max_val="+maxtrace);
     for (int i = 0; i<n; i++) 
     { 
    	 max_val = Math.max(max_val, 
                           price[i] + cutRod(price, n-i-1,i,max_val)); 
     if(i<n)System.out.println(" i="+(i)+" th max_val="+max_val);
     
     }
     if(price.length!=n)System.out.println("\n pop f("+n+")"+"return max of(premaxv,price[i]+maxv,)="+maxtrace+","+ price[x]+"+"+max_val);
     return max_val; 
 } 

 /* Driver program to test above functions */
 public static void main(String args[]) 
 { 
     int arr[] = new int[] {1, 5, 8, 9};//, 10, 17, 17, 20}; 
     int size = arr.length; 
     System.out.println("Maximum Obtainable Value is "+ 
                         cutRod(arr, size,0,-1)); 

 } 
}
