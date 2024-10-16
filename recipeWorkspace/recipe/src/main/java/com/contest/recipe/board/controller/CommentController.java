package com.contest.recipe.board.controller;

import com.contest.recipe.board.domain.Recipte_comment;
import com.contest.recipe.board.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("write")
    public void write(HttpServletRequest request
                      ){

        System.out.println("member_reply_no:"+request.getParameter("member_reply_no"));

        commentService.write(request);

    }

    @GetMapping("list")
    public List<Recipte_comment> list(int recipte_no){

        return commentService.list(recipte_no);


    }

}
