 package edu.gx.common.utils;

public class test {
	   public static void main(String[] args) {
		   String mess="��������ã��������³���ͼ���ס�СȦ��ѧ�ǡ�";
	    	String [] sss=mess.split("��");
		   for(String item: sss){
			   System.out.println(item.substring(0, item.length()-1));
			  }
	}
}
