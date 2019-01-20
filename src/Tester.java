package test;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Collectors;
	
public class Tester extends Object{
	
    /**
     * Complete the function below.
     * DO NOT MODIFY anything outside this method. 
     */
    static boolean[] twins(String[] a, String[] b) {
        boolean[] result = new boolean[a.length];
        for(int i=0;i<a.length|| i<b.length;i++)
        {
        	if(a[i].length()!=b[i].length())
        		{result[i]=false;
        		continue;
        		}
        	if(a[i].equals(b[i])) {
        		result[i]=true;//no swap
        	}
        	if(a[i].length()==b[i].length())
        	{
        		//verify they are anagrams to make replacement
        		String ai=a[i];
        		String bi=b[i];
        	
        		List<String> aList= Arrays.stream(ai.split("")).collect(Collectors.toList());
        		List<String> bList= Arrays.stream(bi.split("")).collect(Collectors.toList());
        		
        		String al=aList.stream().sorted().reduce("",String::concat);
        		String bl=bList.stream().sorted().reduce("",String::concat);
        		if(!al.equals(bl))
        		{
        			result[i]=false;
        			continue;
        		}
        		else {
        			//now anagrams check possibility of equality after swap in table filling algs
        			
        				
        			for(int x=2,y=2;x<aList.size() && y<bList.size();x++,y++)
        			{
        				if(aList.get(x).equals(bList.get(x-2)))
        						swap(aList,x);
        				
        			     				
        			}
        			String newA=aList.stream().reduce("",String::concat);
        			if(newA.equals(b[i]))
        				result[i]=true;
        			else
        				result[i]=false;
        			
        		}
        		
        	}
        	
        }
        return result;
    }

    private static void swap(List<String> aList, int x) {
		String temp=aList.get(x);
		aList.set(x, aList.get(x-2));
		aList.set(x-2, temp);
		
	}

    /**
     * DO NOT MODIFY THIS METHOD!
     */
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int n = Integer.parseInt(in.nextLine().trim());
        String[] a = new String[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextLine();
        }
        
        int m = Integer.parseInt(in.nextLine().trim());
        String[] b = new String[m];
        for(int i = 0; i < m; i++) {
            b[i] = in.nextLine();
        }
        
        // call twins function
        boolean[] results = twins(a, b);
        
        for(int i = 0; i < results.length; i++) {
            System.out.println(results[i]? "Yes" : "No");
        }
    }
}