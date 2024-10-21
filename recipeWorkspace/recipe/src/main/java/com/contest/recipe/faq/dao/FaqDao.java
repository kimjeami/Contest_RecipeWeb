package com.contest.recipe.faq.dao;


import com.contest.recipe.admin.vo.FaqVo;
import com.contest.recipe.faq.mapper.FaqMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FaqDao {
    private final FaqMapper mapper;

    public FaqVo faqDataOne(FaqVo vo) {
        return mapper.faqDataOne(vo);
    }
}
