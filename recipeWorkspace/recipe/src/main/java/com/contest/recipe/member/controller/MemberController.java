package com.contest.recipe.member.controller;

import com.contest.recipe.member.service.MemberService;
import com.contest.recipe.member.vo.MemberVo;
import com.contest.recipe.member.vo.userCountVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
            userCountVo userCount=service.count(loginMemberVo.getNo());
            session.setAttribute("userCountVo", userCount);
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

    //회원가입 화면
    @GetMapping("join")
    public String join(){

        return "member/join";

    }

    //회원가입
    @PostMapping("join")
    public String join(@ModelAttribute MemberVo memberVo, Model model) {
        int joinResult=service.join(memberVo);
        if (joinResult!=1){
            model.addAttribute("errMsg","회원가입 실패");
            return "common/error";
        }

        return "member/login";
    }




    //정보 수정 페이지
    @GetMapping("edit")
    public String edit(MemberVo vo, HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            return "redirect:/member/login";
        }
        return "member/edit";

    }

    //정보 수정
    @PostMapping("edit")
    public String edit(@ModelAttribute MemberVo memberVo, Model model, HttpServletRequest request){
        int editResult=service.edit(memberVo);
        if (editResult!=1){
            model.addAttribute("errMsg","정보수정 실패");
            return "common/error";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginMemberVo", memberVo);

        return "redirect:/recipe";

    }

    //회원 삭제 페이지
    @GetMapping("delete")
    public String delete(MemberVo vo, HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        if (loginMemberVo == null) {
            return "redirect:/member/login";
        }
        return "member/delete";

    }

    // 회원 삭제
    @PostMapping("delete")
    public String delete(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if (loginMemberVo == null) {
            return "redirect:/member/login";
        }

        int deleteResult = service.delete(loginMemberVo.getNo());

        if (deleteResult != 1) {
            model.addAttribute("errMsg", "회원 삭제 실패");
            return "common/error";
        }


        session.invalidate();

        return "redirect:/recipe";
    }

    //회원 목록 임시 보여주기 페이지
    @GetMapping("list")
    public String list(MemberVo vo, HttpServletRequest request, Model model){

        List<MemberVo> memberVoList=service.list();

        model.addAttribute("memberVoList", memberVoList);

        return "member/list";

    }

    //마이페이지
    @GetMapping("mypage")
    public String mypage(MemberVo vo, HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");


        if (loginMemberVo == null) {
            return "redirect:/member/login";
        }
        return "member/mypage";

    }



}
