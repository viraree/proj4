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
		
		
		   
      // �ռ��˵�������
      String to = "1369852622@qq.com";
 
      // �����˵�������
      String from = "1369852622@qq.com";
 
      // ָ�������ʼ�������Ϊ smtp.qq.com
      String host = "smtp.qq.com";  //QQ �ʼ�������
 
      // ��ȡϵͳ����
      Properties properties = System.getProperties();
 
      // �����ʼ�������
      properties.setProperty("mail.smtp.host", host);
 
      properties.put("mail.smtp.auth", "true");
      // ��ȡĬ��session����
      Session session = Session.getDefaultInstance(properties,new Authenticator(){
        public PasswordAuthentication getPasswordAuthentication()
        {
         return new PasswordAuthentication("1369852622@qq.com", "lugurhpzwyrmigie"); //�������ʼ��û�������Ȩ��
        }
       });
 
      try{
         // ����Ĭ�ϵ� MimeMessage ����
         MimeMessage message = new MimeMessage(session);
 
         // Set From: ͷ��ͷ�ֶ�
         message.setFrom(new InternetAddress(from));
 
         // Set To: ͷ��ͷ�ֶ�
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
 
         // Set Subject: ͷ��ͷ�ֶ�
         message.setSubject(subject);
 
         // ������Ϣ��
         message.setText(text);
 
         // ������Ϣ
         Transport.send(message);
         System.out.println("�ʼ����ͳɹ�");
      }catch (MessagingException mex) {
         
		 mex.printStackTrace();
		 res=-1;
      }	
				
		
		return res;
	}
	
	
	
   public static void main(String [] args)
   {
	   SendEmail2 mailer=new SendEmail2();
	   String subject="�Ұ���";
	   String text="����ĺܰ���";
	   
	   mailer.send(subject, text);
	   
	   subject="վ������ã��Һܰ���";
	   text="վ������������˵����ĺܰ���";
	   mailer.send(subject, text);
	   
	   subject="վ�������ã�I love you";
	   text="վ������������˵I really really love you love you";
	   mailer.send(subject, text);
	   
	    
	  
	  
   }
}