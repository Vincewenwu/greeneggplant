 package edu.gx.common.utils;

public class test {
	   public static void main(String[] args) {
		   String mess="张三上午好！我们有新出的图书米《小圈上学记》";
	    	String [] sss=mess.split("《");
		   for(String item: sss){
			   System.out.println(item.substring(0, item.length()-1));
			  }
	}
}
