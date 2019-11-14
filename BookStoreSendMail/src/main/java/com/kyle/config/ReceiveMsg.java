package com.kyle.config;

import com.kyle.client.UserClient;
import com.kyle.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

@Component
public class ReceiveMsg {

    @Value("${spring.mail.username}")
    private String MAIL_SENDER;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Resource
    private UserClient userClient;

    @RabbitListener(queues = "mail")
    public void sendEmail(String str){

        int i = Integer.parseInt(str);
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", i);
        String emailContent = templateEngine.process("index", context);
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(MAIL_SENDER);
            User user = userClient.selectOne(i);
            mimeMessageHelper.setTo(user.getUemail());
            mimeMessageHelper.setSubject("用户邮箱验证账号");

            mimeMessageHelper.setText(emailContent,true);
            javaMailSender.send(mimeMailMessage);
            System.out.println("发送激活邮件成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
