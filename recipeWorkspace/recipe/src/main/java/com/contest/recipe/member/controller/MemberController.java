package com.contest.recipe.member.controller;

import com.contest.recipe.home.vo.RecipeVo;
import com.contest.recipe.member.service.MemberService;
import com.contest.recipe.member.vo.MemberVo;
import com.contest.recipe.member.vo.userCountVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



        if(loginMemberVo != null && loginMemberVo.getDelYn().equals("N")){
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
        return "redirect:/member/login";
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
        HttpSession session = request.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        memberVo.setNo(loginMemberVo.getNo());

        int editResult=service.edit(memberVo);
        if (editResult!=1){
            model.addAttribute("errMsg","정보수정 실패");
            return "common/error";
        }

        loginMemberVo.setBirth(memberVo.getBirth());
        loginMemberVo.setAddress(memberVo.getAddress());
        loginMemberVo.setAddressDetail(memberVo.getAddressDetail());
        loginMemberVo.setAddressExtra(memberVo.getAddressExtra());
        loginMemberVo.setPostcode(memberVo.getPostcode());
        loginMemberVo.setEmail(memberVo.getEmail());
        loginMemberVo.setNick(memberVo.getNick());
        loginMemberVo.setPhone(memberVo.getPhone());

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
    public String delete(@RequestParam("pwd") String password,Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");



        if (loginMemberVo == null) {
            return "redirect:/member/login";
        }

        if(!loginMemberVo.getPwd().equals(password)){
            model.addAttribute("errMsg", "회원 삭제 실패");
            return "common/error";
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

    //내정보
    @GetMapping("information")
    public String information(MemberVo vo, HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if (loginMemberVo == null) {
            return "redirect:/member/login";
        }
        List<RecipeVo> myRecipeList = service.getMyRecipes(loginMemberVo.getNo());
        model.addAttribute("myRecipeList", myRecipeList);

        List<MemberVo> memberFollowerList=service.getFollowerList(loginMemberVo.getNo());
        model.addAttribute("memberFollowerList",memberFollowerList);

        List<MemberVo> memberFollowingList=service.getFollowingList(loginMemberVo.getNo());
        model.addAttribute("memberFollowingList",memberFollowingList);

        return "member/information";

    }

    //내정보
    @GetMapping("user")
    public String user(@RequestParam("member_no") String member_no,MemberVo vo, HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if (loginMemberVo == null) {
            return "redirect:/member/login";
        }




        List<RecipeVo> myRecipeList = service.getMyRecipes(member_no);
        model.addAttribute("myRecipeList", myRecipeList);

        List<MemberVo> memberFollowerList=service.getFollowerList(member_no);
        model.addAttribute("memberFollowerList",memberFollowerList);

        List<MemberVo> memberFollowingList=service.getFollowingList(member_no);
        model.addAttribute("memberFollowingList",memberFollowingList);

        return "member/user";

    }

    @PostMapping("follow")
    public ResponseEntity<String> follow(@RequestBody Map<String, String> payload, HttpServletRequest request) {
        HttpSession session = request.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if (loginMemberVo == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        String memberNo = payload.get("no");

        try {
            service.followMember(loginMemberVo.getNo(), memberNo);
            userCountVo userCount=service.count(loginMemberVo.getNo());
            session.setAttribute("userCountVo", userCount);
            return ResponseEntity.ok("팔로우 성공");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("팔로우에 실패했습니다.");
        }
    }

    // 팔로우 취소
    @PostMapping("unfollow")
    public ResponseEntity<String> unfollow(@RequestBody Map<String, String> payload, HttpServletRequest request) {
        HttpSession session = request.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if (loginMemberVo == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }

        String memberNo = payload.get("no");

        try {
            service.unfollowMember(loginMemberVo.getNo(), memberNo);
            userCountVo userCount=service.count(loginMemberVo.getNo());
            session.setAttribute("userCountVo", userCount);
            return ResponseEntity.ok("팔로우 취소 성공");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("팔로우 취소에 실패했습니다.");
        }
    }

    //아이디 중복 체크
    @PostMapping("/checkId")
    @ResponseBody
    public Map<String, Object> checkId(@RequestBody Map<String, String> param) {
        String id = param.get("id");
        boolean isAvailable = service.checkIdAvailability(id);
        Map<String, Object> response = new HashMap<>();
        response.put("isAvailable", isAvailable);
        return response;
    }

    //비밀번호 변경
    @PostMapping("changePassword")
    @ResponseBody
    public Map<String, Object> changePassword(@RequestBody Map<String, String> passwordData,HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();



        String currentPwd = passwordData.get("currentPwd");
        String newPwd = passwordData.get("newPwd");

        System.out.println("newPwd = " + newPwd);
        System.out.println("currentPwd = " + currentPwd);

        HttpSession session = request.getSession();
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        if (loginMemberVo != null && loginMemberVo.getPwd().equals(currentPwd)) {
            boolean isUpdated = service.updatePassword(loginMemberVo.getId(), newPwd);

            if (isUpdated) {
                response.put("success", true);
            } else {
                response.put("success", false);
                response.put("message", "비밀번호 변경 중 오류가 발생했습니다.");
            }
        } else {
            response.put("success", false);
            response.put("message", "현재 비밀번호가 일치하지 않습니다.");
        }

        return response;
    }



}
