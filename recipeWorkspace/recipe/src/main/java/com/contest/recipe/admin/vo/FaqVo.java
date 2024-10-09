package com.contest.recipe.admin.vo;

import lombok.Data;

/**
 * FAQ 데이터 VO
 */
@Data
public class FaqVo {
    private Integer no;
    private String title;
    private String content;
    private Boolean delYn;
}
