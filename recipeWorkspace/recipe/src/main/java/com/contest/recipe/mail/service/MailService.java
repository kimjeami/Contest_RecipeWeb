package com.contest.recipe.mail.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;
    private static final String senderEmail= "dydwls8369@gmail.com";
    private static int number;
    private final Map<String, String> verificationCodes = new HashMap<>();

    public static void createNumber(){
        number = (int)(Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값
    }

    public MimeMessage CreateMail(String mail){
        createNumber();
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, mail);
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }

    public int sendMail(String mail){
        createNumber();
        MimeMessage message = CreateMail(mail);
        javaMailSender.send(message);

        // 인증번호를 Map에 저장
        verificationCodes.put(mail, String.valueOf(number));


        return number;
    }

    public boolean checkVerificationCode(String mail, String code) {
        System.out.println("mail = " + mail);
        System.out.println("code = " + code);
        return verificationCodes.containsKey(mail) && verificationCodes.get(mail).equals(code);
    }
}
