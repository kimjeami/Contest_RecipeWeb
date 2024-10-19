package com.contest.recipe.admin.controller;

import com.contest.recipe.admin.service.NotionService;
import com.contest.recipe.admin.vo.notionVo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public class NotionController {
    private final NotionService service;

    @ResponseBody
    @GetMapping("notionData")
    public List<notionVo> notionData(notionVo vo){
        return service.notionData(vo);
    }

    @GetMapping("notionList")
    public String notionList(){
        return "admin/notionList";
    }


    @ResponseBody
    @GetMapping("notionDetailData")
    public notionVo notionDetailData(notionVo vo){
        return service.notionDetailData(vo);
    }

    @GetMapping("notionDetail")
    public String notionDetail(){
        return "admin/notionDetail";
    }

    @GetMapping("notionModify")
    public String notionModify(notionVo vo,HttpServletRequest req){
        notionVo nVo = service.notionDetailData(vo);
        req.setAttribute("vo",nVo);
        return "admin/notionModify";
    }

    @ResponseBody
    @PostMapping("notionModify")
    public String notionModify(notionVo vo){
        int result = service.notionModify(vo);

        if(result != 1){

            return "admin/notionList";
        }
        return "admin/notionList";
    }
}
