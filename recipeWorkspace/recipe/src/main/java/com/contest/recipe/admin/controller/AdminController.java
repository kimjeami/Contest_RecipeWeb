package com.contest.recipe.admin.controller;


import com.contest.recipe.admin.service.AdminService;
import com.contest.recipe.admin.vo.AdminVo;
import com.contest.recipe.member.vo.MemberVo;
import com.contest.recipe.rank.vo.RankVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService service;

    @GetMapping("sessionHome")
    public String adminHome(HttpSession session){
        AdminVo adminVo = (AdminVo)session.getAttribute("adminVo");
        List<RankVo> rankVo = (List<RankVo>) session.getAttribute("rankVo");
        if(adminVo == null){
            throw new RuntimeException("adminVo가 null입니다");
        }
        if(rankVo != null){
            return "admin/sessionHome";
        }
        else{
            return "admin/sessionHome";
        }
    }

    @GetMapping("login")
    public String adminLogin(){
        return "admin/login";
    }

    @PostMapping("login")
    public String adminLogin(AdminVo vo, HttpSession session, HttpServletRequest req){
        AdminVo adminVo = service.adminLogin(vo);
        if(adminVo != null){
            session.setAttribute("adminVo",adminVo);
            return "admin/sessionHome";
        }
        else{
            return "admin/login";
        }
    }

/////위에 코드는 임시로 js로그인 확인 절차 세션으로 부여할거 고민해야됨 loginVo,List<RankVo>이 두개를 세션에 담아 전달해야 완료


    @ResponseBody
    @GetMapping("rankData")
    public String rankData(AdminVo vo,HttpSession session){
        List<RankVo> rankVo = service.adminRankData(vo);
        if(rankVo != null){
            session.setAttribute("rankVo",rankVo);
            return "admin/sessionHome";
        }
        else {
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

    /**
     * 메인 페이지 테스트용 메서드
     * @return
     */
    @GetMapping("testHome")
    public String testHome() {
        System.out.println("testHome Function Entered");
        return "admin/adminhome";
    }

    /**
     * 어드민 사이드바 테스트
     * @return
     */
    @GetMapping("testAdminSidebar")
    public String testAdminSidebar() {
        System.out.println("testAdminSidebar Function Entered");
        return "admin/testAdminhome";
    }

    /**
     * 어드민 홈 테스트
     * @return
     */
    @GetMapping("testAdminhome")
    public String testAdminhome(Model model) {
        System.out.println("testAdminhome Function Entered");

        service.loadAdminHome(model);

        return "admin/testAdminhome";
    }

    @GetMapping("testAdminQnaList")
    public String testAdminQnaList(
            Model model,
            @RequestParam(required = false) Integer cat,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) String keyword
            ) {

        return "admin/qnaList";
    }

}
