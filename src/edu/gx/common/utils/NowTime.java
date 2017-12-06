package edu.gx.common.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NowTime {
	/**
	 * 当前时间
	 * @return
	 */
	 public static void main(String[] args) {
		 SimpleDateFormat sf=null;
		 Calendar c=null;
		 Date date = null; 
			 sf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			  c=Calendar.getInstance();
			 c.add(c.DAY_OF_MONTH, 0);
		try {
			  date = sf.parse(sf.format(c.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Timestamp timestamp = new Timestamp(date.getTime()); 
		System.out.println(timestamp);
	}
	
	public Timestamp BorrowDate(){
		SimpleDateFormat sf=null;
		 Calendar c=null;
		 Date date = null; 
			 sf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			  c=Calendar.getInstance();
			 c.add(c.DAY_OF_MONTH, 0);
		try {
			  date = sf.parse(sf.format(c.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Timestamp timestamp = new Timestamp(date.getTime()); 
		return timestamp;
	}
  public  int AMorPM()  
  {  
	GregorianCalendar ca = new GregorianCalendar();  
	return ca.get(GregorianCalendar.AM_PM);  
   }  
  public long fanhuishifouguoqi(String date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date one;  
      Date two; 
      long days=0;  
      try {  
          one = df.parse(date); /*借阅时间 */
          two = df.parse(BorrowDate().toString());  /* 当前时间*/
          long time1 = one.getTime();  
          long time2 = two.getTime();  
          long diff = 0 ;  
          if(time1<time2) {  
              diff = time2 - time1;  
          } else { 
          } 
          days = diff / (1000 * 60 * 60 * 24);  
      } catch (ParseException e) {  
          e.printStackTrace();  
      }
		return days;
	}
}
