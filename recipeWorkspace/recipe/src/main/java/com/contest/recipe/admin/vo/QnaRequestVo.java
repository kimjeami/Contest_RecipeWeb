package com.contest.recipe.admin.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Q&A 요청 데이터 VO
 */
@Data
public class QnaRequestVo {
    private Integer qnaRequestNo;
    private Integer qnaCategoryNo;
    private LocalDateTime qnaRequestCreatedDate;
    private LocalDateTime qnaRequestLastActivityDate;
    private Integer memberNo;
    private Integer qnaRequestStatus;
    private String qnaRequestTitle;
}
