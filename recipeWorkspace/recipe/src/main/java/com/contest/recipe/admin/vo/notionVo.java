package com.contest.recipe.admin.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 공지사항 데이터 VO
 */
@Data
public class notionVo {
    private Integer no;
    private String title;
    private String content;
    private Integer hit;
    private LocalDateTime enrollDate;
    private LocalDateTime modifyDate;
    private String delYn;
}
