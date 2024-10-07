package com.contest.recipe.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recipte_comment {
    private int no; // 댓글 번호
    private int recipte_no; // 레시피 번호
    private int member_reply_no; // 작성자 번호
    private String  answer ; // 댓글내용
    private LocalDateTime write_date ; // 작성일
    private char del_yn; // 삭제 여부
    private int scope; // 별점
    private String member_name; // 작성자 명
}
