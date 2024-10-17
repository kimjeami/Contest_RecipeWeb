package com.contest.recipe.board.controller;



import com.contest.recipe.board.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;


// 레시피 페이지
@Controller
@RequestMapping("/recipe")
public class BoardController {

    @Autowired
    private BoardService boardService;



    // 작성 페이지
    @GetMapping("write")
    public String write() {
        return "Board/write";
    }

    @PostMapping("write")
    public String writeOk(MultipartHttpServletRequest mul, HttpServletResponse response,
                        HttpServletRequest request) {

            try{
                boardService.write(mul, response, request);
                return "redirect:/recipe/list";
            }catch (Exception e){
                e.printStackTrace();
            }

        return "Board/write";
    }


    // 목록 페이지
    @GetMapping("list")
    public  String list(Model model,@RequestParam(required = false) String keyword, Integer page) {

        boardService.recipeList(model,keyword,page);


        return "Board/list";

    }






    // 상세 페이지
    @GetMapping("detail")
    public String detail(@RequestParam("recipte_no")int recipte_no, Model model) {

        //상세 페이지
        boardService.recipeDetail(recipte_no,model);
        return "Board/detail";
    }

    // 수정 페이지
    // 수정할 글 가져오기
    @GetMapping("modifyForm")
    public String modifyForm(@RequestParam("recipte_no")int recipte_no, Model model){

        boardService.recipeModifyForm(recipte_no,model);


        return "Board/modifyForm" ;
    }

    // 수정 하기
    @PostMapping("modify")
    public  String modify(MultipartHttpServletRequest mul,
                          HttpServletRequest request){
        boardService.recipeMoidfy(mul,request);

        int recipte_no = Integer.parseInt(mul.getParameter("recipte_no"));


        return "redirect:/recipe/detail?recipte_no="+recipte_no;

    }

    // 삭제하기
    @GetMapping("delete")
    public String delete(@RequestParam("recipte_no")int recipte_no,Model model){

        int result = boardService.recipeDelete(recipte_no);
        model.addAttribute("result", result);
        return "Board/delete";

    }

    // 문의하기
    @GetMapping("inquiryForm")
    public String inquiryForm(@RequestParam("recipte_no")int recipte_no,Model model){

        boardService.recipeInquiry(recipte_no,model);

        return "Board/inquiryForm";
    }

    // 글 등록
    @PostMapping("inquirysave")
    public String inquirysave(HttpServletRequest request){




       boardService.inquirysave(request);

        return  "Board/inquiry";
    }

    // 작성한 문의 리스트 가져오기
    @GetMapping("inquirylist")
    public String inquirylist(@RequestParam("write_no")int write_no,Model model) {

        boardService.inquirylist(write_no,model);

        return "Board/inquirylist";
    }

    // 답변할 문의 리스트 가져오기
    @GetMapping("answerlist")
    public String answerlist(@RequestParam("awnser_no")int awnser_no,Model model) {
            boardService.answerlist(awnser_no,model);

        return "Board/answerlist";
    }


    // 레시피 문의 가져오기
    @GetMapping("inquiry")
    public String inquiry(@RequestParam("recipte_no")int recipte_no,@RequestParam("write_no")int write_no,@RequestParam("awnser_no")int awnser_no,Model model){

        boardService.inquirydetail(recipte_no,write_no,awnser_no,model);
        return  "Board/inquiry";
    }

    // 답변할 내용 작성
    @GetMapping("answerForm")
    public  String answerForm(@RequestParam("recipte_no")int recipte_no,@RequestParam("write_no")int write_no,@RequestParam("awnser_no")int awnser_no,Model model){

        boardService.answerForm(recipte_no,write_no,awnser_no,model);
        return  "Board/answerForm";
    }

    // 답변 하기
    @PostMapping("answer")
    public  String answer(HttpServletRequest request) {

            boardService.answer(request);
        return "Board/answer";
    }
}
