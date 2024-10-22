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
public class Recipe {
    // 레시피 관련 데이터
    private int recipte_no; // 레시피 번호
    private int write_no; // 작성자 번호
    private int recipe_cate_no; // 카테고리 번호
    private String title ; // 레시피 제목
    private String introduce ; // 레시피 소개
    private String thumbnail; // 레시피 이미지
    private String tip; // 레시피 팁
    private LocalDateTime enroll_date; // 등록일
    private LocalDateTime modify_date; // 수정일
    private char del_yn; // 레시피 삭제  y면 레시피가 글이 안보임
    private int hit; // 조회수
    private int state; // 판매상태
    private String step; // 난이도
    private String time_taken; // 만드는 시간
    private String serving; // 인분 체크
    private String ea;// 수량
    private String things_name; // 재료 이름
    private String things_url; // 재료 링크
    private int recipte_order; // 레시피 순서
    private String  explanation; // 레시피 내용
    private String recipe_seq_img; // 레시피 순서 이미지
    private String write_name; // 작성자 이름

    private Star star;
}
