package com.contest.recipe.mail.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;
    private final RedisTemplate<String, String> redisTemplate;
    private static final String senderEmail = "dydwls8369@gmail.com";
    private static int number;

    public static void createNumber() {
        number = (int) (Math.random() * 90000) + 100000; // 100000 ~ 999999 범위
    }

    public MimeMessage CreateMail(String mail) {
        createNumber();
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, mail);
            message.setSubject("이메일 인증");
            String body = "<h3>요청하신 인증 번호입니다.</h3>"
                    + "<h1>" + number + "</h1>"
                    + "<h3>감사합니다.</h3>";
            message.setText(body, "UTF-8", "html");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }

    public int sendMail(String mail) {
        createNumber();
        MimeMessage message = CreateMail(mail);
        javaMailSender.send(message);

        redisTemplate.opsForValue().set(mail, String.valueOf(number), Duration.ofMinutes(5));

        return number;
    }

    public boolean checkVerificationCode(String mail, String code) {
        System.out.println("mail = " + mail);
        System.out.println("code = " + code);

        String storedCode = redisTemplate.opsForValue().get(mail);

        return storedCode != null && storedCode.equals(code);
    }
}
