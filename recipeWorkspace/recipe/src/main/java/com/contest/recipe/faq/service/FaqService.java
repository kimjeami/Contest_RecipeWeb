package com.contest.recipe.faq.service;


import com.contest.recipe.admin.vo.FaqVo;
import com.contest.recipe.faq.dao.FaqDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FaqService {
    private final FaqDao dao;

    public FaqVo faqDataOne(FaqVo vo) {
        return dao.faqDataOne(vo);
    }
}
