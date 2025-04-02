package com.contest.recipe.test.controller;


import com.contest.recipe.test.service.TestService;
import com.contest.recipe.test.vo.TestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("hello")
@RequiredArgsConstructor
public class TestController {
    private final TestService service;

    @GetMapping("home")
    public String home(String name,Model model){
        System.out.println("HelloController.home~~~~~~~~~~");

        List<TestVo> testVoList=service.list();

        model.addAttribute("testVoList", testVoList);

        return "test/home";
    }

}
