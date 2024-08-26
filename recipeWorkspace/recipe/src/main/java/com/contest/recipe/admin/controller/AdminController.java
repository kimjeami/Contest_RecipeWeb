package com.contest.recipe.admin.controller;


import com.contest.recipe.admin.service.AdminService;
import com.contest.recipe.admin.vo.AdminVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService service;


    @GetMapping("login")
    public String adminLogin(){
        return "Admin/login";
    }
    @PostMapping("login")
    public String adminLogin(AdminVo vo, HttpSession session){
        AdminVo loginAdminVo = service.adminLogin(vo);
        if(loginAdminVo != null){
            session.setAttribute("loginAdminVo",loginAdminVo);
            return "home";
        }
        else {
            return "Admin/login";
        }
    }

}
