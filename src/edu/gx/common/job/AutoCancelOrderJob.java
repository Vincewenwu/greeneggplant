package edu.gx.common.job;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import edu.gx.dao.service.IBorrowService;
import edu.gx.dao.service.IRoleService;
import edu.gx.user.model.Borrow;
import edu.gx.user.model.Role;
;
public class AutoCancelOrderJob implements Job{
	
	private static Logger log = Logger.getLogger(AutoCancelOrderJob.class);
	public static boolean running = false;	
	
	@Autowired
	private IBorrowService iBorrowService;
	@Autowired
	private IRoleService iRoleService;
	private List<Borrow> borrowlist =null;
	private Role role =null;
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		if(running)
		{
			log.info("上一次程序正在运行中....");
			return;
		}
		running = true;
		log.info("自动关闭无效订单");	
		
		try {
			borrowlist=iBorrowService.list("form Borrow");
			if(borrowlist!=null && borrowlist.size()>0){
				for(Borrow borrow : borrowlist){
					role=iRoleService.findById(borrow.getUserId());
					if(daysBetween(borrow.getBorrowDate(),new Date())>=role.getBorrowBooksLength()){
						borrow.setWhetherReturn(false);
						//更新订单状态  用户下单超过自定义天数天未支付 自动关闭该订单
						iBorrowService.update(borrow);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		
		running = false;	
	}
	/**
	 * @Title: daysBetween 
	 * @Description: 相差的天数
	 * @param date1
	 * @param date2
	 * @return
	 */	
	public static int daysBetween(Date date1,Date date2)
	{
		int days = 0;
		if(date1!=null&&date2!=null)
		{
	    	try {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				date1=sdf.parse(sdf.format(date1));
				date2=sdf.parse(sdf.format(date2));
				Calendar cal = Calendar.getInstance();  
				cal.setTime(date1);  
				long time1 = cal.getTimeInMillis();               
				cal.setTime(date2);  
				long time2 = cal.getTimeInMillis();       
				long betweenDays=(time2-time1)/(1000*3600*24);
				days =Math.abs((int)betweenDays);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				days = -1;
			}
		}
		return days;
	}	

}
