package com.contest.recipe.admin.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Q&A 요청상세 데이터 VO
 */
@Data
public class QnaReplyVo {
    private Integer qnaReplyNo;
    private Integer qnaRequestNo;
    private LocalDateTime qnaReplyDate;
    private Integer adminNo;
    private Integer no;
    private String qnaReplyContent;
}
