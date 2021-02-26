package com.weyoung.wxapp.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * 发送邮件
 * @author li
 */
public class SendEmailUtil {

    public static void send(JavaMailSender mailSender,String title, String type, String tel,
                               String username, String address) throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("878728568@qq.com");
        helper.setTo("878728568@qq.com");
        helper.setSubject("你有一条新的"+title+"订单");
        String content="<h4>服务内容："+type+"</h4>" +
                "<h4>联系电话："+tel+"</h4>" +
                "<h4>联系人："+username+"</h4>" +
                "<h4>地址："+address+"</h4>" +
                "<h4>网站地址：https://1haokx.com</h4>";
        helper.setText(content, true);
        mailSender.send(mimeMessage);
    }
}
