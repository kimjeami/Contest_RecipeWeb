package com.contest.recipe.board.controller;

import com.contest.recipe.board.service.StarService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

}
