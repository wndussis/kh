package com.kh.test.break_continue;

import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) {
		   Test1 t = new Test1();
		   t.test1();
		
	}
    public void test1() {
	       Scanner sc = new Scanner(System.in);
	       System.out.println("정수를 하나 입력하세요. =>");
	       final int NUM1 = sc.nextInt();
	       
	       int i = 0;
	       int total = 1;
	       
	       while (i < NUM1) {
	    	      i++;
	    	      
	    	      if(i % 2 == 0) {
	    	    	  continue;
	    	    	  
	    	      }
	    	      else {
	    	    	  total *= i;
	    	      }
	       }
	       System.out.println(total);
	
	      
	    	   
	       }
	
	
	
}

