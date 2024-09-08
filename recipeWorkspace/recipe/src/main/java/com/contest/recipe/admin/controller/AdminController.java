package com.contest.recipe.admin.controller;


import com.contest.recipe.admin.service.AdminService;
import com.contest.recipe.admin.vo.AdminSessionVo;
import com.contest.recipe.admin.vo.AdminVo;
import com.contest.recipe.rank.vo.RankVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService service;


    @GetMapping("login")
    public String adminLogin(){
        return "admin/login";
    }
    @PostMapping("login")
    public String adminLogin(AdminVo vo, HttpSession session, HttpServletRequest req){
        AdminVo loginAdminVo = service.adminLogin(vo);
        List<RankVo> voList =  service.adminRankData(vo);
        AdminSessionVo SessionVo = new AdminSessionVo(loginAdminVo,voList);


        req.getAttribute("voList");
        if(loginAdminVo != null && voList != null){
            session.setAttribute("loginAdminVo",loginAdminVo);
            return "home";
        }
        else {
            return "admin/login";
        }
    }

}
