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
public class Recipe_inquiry {
    private int no; //문의 번호
    private int recipte_no; // 레시피 번호
    private int write_no; // 작성자 번호
    private String write_nick; // 작성자 명
    private int awnser_no; // 답변자 번호
    private String awnser_nick; // 답변자 명
    private String title; // 제목
    private String content; // 내용
    private char del_yn; // 삭제 여부
    private LocalDateTime enroll_date; // 작성일
    private String answer; // 답변 내용
    private LocalDateTime answer_date ; // 답변일
    private char state; // 답변 상태
}
