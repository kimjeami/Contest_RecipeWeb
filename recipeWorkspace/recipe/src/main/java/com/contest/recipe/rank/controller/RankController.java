package com.contest.recipe.rank.controller;


import com.contest.recipe.rank.service.RankService;
import com.contest.recipe.rank.vo.RankVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("rank")
public class RankController {

    private final RankService service;


    @GetMapping("data")
    @ResponseBody
    public List<RankVo> rankData(RankVo vo){
        return service.rankData(vo);
    }
}
