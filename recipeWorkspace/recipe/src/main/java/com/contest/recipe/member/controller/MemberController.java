package com.contest.recipe.member.controller;

import com.contest.recipe.member.service.MemberService;
import com.contest.recipe.member.vo.MemberVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService service;

    //멤버 로그인화면
    @GetMapping("login")
    public String login(){

        return "member/login";

    }

    //멤버로그인
    @PostMapping("login")
    public String login(MemberVo vo, HttpServletRequest request, Model model){

        HttpSession session = request.getSession();
        MemberVo loginMemberVo = service.login(vo);

        if(loginMemberVo != null ){
            session.setAttribute("loginMemberVo", loginMemberVo);
            //레시피 화면으로
            return "redirect:/recipe";

        }else{
            model.addAttribute("errMsg","로그인 실패");
            return "common/error";
        }
    }

    //로그아웃
    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/recipe";
    }




}
