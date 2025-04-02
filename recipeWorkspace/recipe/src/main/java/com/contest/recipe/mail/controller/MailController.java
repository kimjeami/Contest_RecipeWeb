package com.contest.recipe.mail.controller;

import com.contest.recipe.mail.service.MailService;
import com.contest.recipe.test.vo.TestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("mail")
@RequiredArgsConstructor
public class MailController {

    private final RedisTemplate<String, String> redisTemplate;
    private final MailService service;

    @GetMapping("/home")
    public String home(String name, Model model){

        return "mail/mailTest";
    }

    @PostMapping("/send")
    @ResponseBody
    public String sendMail(@RequestBody Map<String, String> request) {
        String mail = request.get("mail");
        int number = service.sendMail(mail);

        return "인증번호가 이메일로 전송되었습니다.";
    }

    @PostMapping("verify")
    @ResponseBody
    public String verifyCode(@RequestBody Map<String, String> request) {
        System.out.println("Contorller mail = " + request.get("mail"));
        System.out.println("Controller code = " + request.get("code"));
        if (service.checkVerificationCode(request.get("mail"), request.get("code"))) {
            return "success"; 
        }
        return "fail";
    }

}
