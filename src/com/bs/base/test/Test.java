package com.bs.base.test;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class Test {
      public static void main(String[] args) {
    		mail("1069871455@qq.com","mybatis plus");//�����ʼ�
	}
      public static void mail(String mail,String title){
 		 Properties prop = new Properties();
 	        // ����debug���ԣ��Ա��ڿ���̨�鿴
 	        prop.setProperty("mail.debug", "true");
 	        // �����ʼ�������������
 	        prop.setProperty("mail.host", "smtp.qq.com");
 	        // ���ͷ�������Ҫ�����֤
 	        prop.setProperty("mail.smtp.auth", "true");
 	        // �����ʼ�Э������
 	        prop.setProperty("mail.transport.protocol", "smtp");

 	        // ����SSL���ܣ������ʧ��
 	        MailSSLSocketFactory sf = null;
 			try {
 				sf = new MailSSLSocketFactory();
 			} catch (GeneralSecurityException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 	        sf.setTrustAllHosts(true);
 	        prop.put("mail.smtp.ssl.enable", "true");
 	        prop.put("mail.smtp.ssl.socketFactory", sf);

 	        // ����session
 	        Session session = Session.getInstance(prop);

 	        // ͨ��session�õ�transport����
 	        Transport ts = null;
 			try {
 				ts = session.getTransport();
 			} catch (NoSuchProviderException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 	        // �����ʼ����������������ͣ��ʺţ���Ȩ��������루����ȫ��
 	        try {
 				ts.connect("smtp.qq.com", "1010789554", "ukgyonykdfjpbfib");
 			} catch (MessagingException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 	        // ������ַ�����Ȩ�룬��qq����ʧ����

 	        // �����ʼ�
 	        Message message = null;
 			try {
 				message = createSimpleMail(session,mail,title);
 			} catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 	        // �����ʼ�
 	        try {
 				ts.sendMessage(message, message.getAllRecipients());
 			} catch (MessagingException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 	        try {
 				ts.close();
 			} catch (MessagingException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 	}
      /**
       * @Method: createSimpleMail
       * @Description: ����һ��ֻ�����ı����ʼ�
       */
      public static MimeMessage createSimpleMail(Session session,String mail,String title)
              throws Exception {
          // �����ʼ�����
          MimeMessage message = new MimeMessage(session);
          // ָ���ʼ��ķ�����
          message.setFrom(new InternetAddress("1010789554@qq.com"));
          // ָ���ʼ����ռ���
          message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.toString().trim()));
          // �ʼ��ı���
          message.setSubject(title);
          // �ʼ����ı�����
          message.setContent("�����ʼ��ɹ���", "text/html;charset=UTF-8");
          // ���ش����õ��ʼ�����
          return message;
    }
}
