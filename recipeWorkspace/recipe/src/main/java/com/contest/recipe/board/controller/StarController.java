package com.contest.recipe.board.controller;

import com.contest.recipe.board.domain.Star;
import com.contest.recipe.board.service.StarService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/star")
public class StarController {


    @Autowired
    private StarService starService;

    @PostMapping("write")
    public void write(HttpServletRequest request
    ){


        starService.write(request);

    }


    @PostMapping("update")
    public  void update(HttpServletRequest request){

        starService.update(request);
    }


    @GetMapping("getstar")
    public ResponseEntity getstar(int recipte_no, int member_no){

        Star star = starService.getStar(recipte_no,member_no);

        if(star != null) {
            return  ResponseEntity.ok(star);
        }
        else {
            return  ResponseEntity.noContent().build();
        }



    }


}
