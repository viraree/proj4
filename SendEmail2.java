package tggroup;


import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendEmail2
{
	
	
   public int send(String subject, String text)
	{
		int res=1;
		
		
		   
      // 收件人电子邮箱
      String to = "1369852622@qq.com";
 
      // 发件人电子邮箱
      String from = "1369852622@qq.com";
 
      // 指定发送邮件的主机为 smtp.qq.com
      String host = "smtp.qq.com";  //QQ 邮件服务器
 
      // 获取系统属性
      Properties properties = System.getProperties();
 
      // 设置邮件服务器
      properties.setProperty("mail.smtp.host", host);
 
      properties.put("mail.smtp.auth", "true");
      // 获取默认session对象
      Session session = Session.getDefaultInstance(properties,new Authenticator(){
        public PasswordAuthentication getPasswordAuthentication()
        {
         return new PasswordAuthentication("1369852622@qq.com", "46546546546546546456"); //发件人邮件用户名、授权码
        }
       });
 
      try{
         // 创建默认的 MimeMessage 对象
         MimeMessage message = new MimeMessage(session);
 
         // Set From: 头部头字段
         message.setFrom(new InternetAddress(from));
 
         // Set To: 头部头字段
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
 
         // Set Subject: 头部头字段
         message.setSubject(subject);
 
         // 设置消息体
         message.setText(text);
 
         // 发送消息
         Transport.send(message);
         System.out.println("邮件发送成功");
      }catch (MessagingException mex) {
         
		 mex.printStackTrace();
		 res=-1;
      }	
				
		
		return res;
	}
	
	
	
   public static void main(String [] args)
   {
	   SendEmail2 mailer=new SendEmail2();
	   String subject="我爱你";
	   String text="我真的很爱你";
	   
	   mailer.send(subject, text);
	   
	   subject="站长，你好，我很爱你";
	   text="站长，请允许我说我真的很爱你";
	   mailer.send(subject, text);
	   
	   subject="站长，您好，I love you";
	   text="站长，请允许我说I really really love you love you";
	   mailer.send(subject, text);
	   
	    
	  
	  
   }
}
