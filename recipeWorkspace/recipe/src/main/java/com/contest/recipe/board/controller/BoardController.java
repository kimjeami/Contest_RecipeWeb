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
import org.springframework.web.multipart.MultipartHttpServletRequest;


// 레시피 페이지
@Controller
@RequestMapping("/board")
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
                return "redirect:/board/list";
            }catch (Exception e){
                e.printStackTrace();
            }

        return "Board/write";
    }


    // 목록 페이지
    @GetMapping("list")
    public  String list(Model model) {

        boardService.recipeList(model);

        return "Board/list";

    }


}
