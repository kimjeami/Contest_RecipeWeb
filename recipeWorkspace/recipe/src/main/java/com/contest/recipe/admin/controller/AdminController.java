package com.contest.recipe.admin.controller;


import com.contest.recipe.admin.service.AdminService;
import com.contest.recipe.admin.vo.AdminVo;
import com.contest.recipe.member.vo.MemberVo;
import com.contest.recipe.rank.vo.RankVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService service;

    @GetMapping("home")
    public String adminHome(HttpSession session){
        AdminVo adminVo = (AdminVo)session.getAttribute("adminVo");
        List<RankVo> rankVo = (List<RankVo>) session.getAttribute("rankVo");
        if(adminVo == null){
            throw new RuntimeException("adminVo가 null입니다");
        }
        if(rankVo != null){
            return "home";
        }
        else{
            return "home";
        }
    }

    @GetMapping("login")
    public String adminLogin(){
        return "/admin/login";
    }

/////위에 코드는 임시로 js로그인 확인 절차 세션으로 부여할거 고민해야됨 loginVo,List<RankVo>이 두개를 세션에 담아 전달해야 완료


    @ResponseBody
    @GetMapping("rankData")
    public String rankData(AdminVo vo,HttpSession session){
        List<RankVo> rankVo = service.adminRankData(vo);
        if(rankVo != null){
            session.setAttribute("rankVo",rankVo);
            return "home";
        }
        else {
            return "admin/login";
        }
    }

    @PostMapping("login")
    public String adminLogin(AdminVo vo, HttpSession session, HttpServletRequest req){
        AdminVo adminVo = service.adminLogin(vo);
        if(adminVo != null){
            session.setAttribute("adminVo",adminVo);
            return "home";
        }
        else{
            return "admin/login";
        }
    }

    @ResponseBody
    @GetMapping("userData")
    public List<MemberVo> userData(MemberVo vo){
        return service.userData(vo);
    }

    @GetMapping("userCheck")
    public String userCheck(MemberVo vo){

        return "admin/userCheck";
    }

    @GetMapping("testHome")
    public String testHome() {
        System.out.println("testHome Function Entered");
        return "Admin/adminhome";
    }

}
