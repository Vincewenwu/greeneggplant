package edu.gx.common.utils;

import java.util.Date;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import edu.gx.dao.service.IBookService;
import edu.gx.user.model.Book;
public class TestJob2 extends QuartzJobBean{
	@Autowired
	private IBookService iBookService;
	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		   System.out.println("TestJob2:"+new Date());
		   System.out.println("进入定时");
		   Book book1=new Book();
		   book1= iBookService.load(74);
		   System.out.println(book1);
	}
}
