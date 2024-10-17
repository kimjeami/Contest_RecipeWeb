package com.contest.recipe.board.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {


    // 레시피 작성
    public void write(MultipartHttpServletRequest mul, HttpServletResponse response,
                       HttpServletRequest request);
    // 레시피 가져오기
    public void recipeList(Model model,String keyword, Integer page);

    // 레시피 상세보기
    public void recipeDetail(int recipte_no, Model model);

    // 레시피 수정할 데이터 가져오기
    public  void  recipeModifyForm(int recipte_no, Model model);
    // 레시피 수정 하기
    public  void recipeMoidfy(MultipartHttpServletRequest mul,
                              HttpServletRequest request);
    // 레시피 삭제 하기
    public int recipeDelete(int recipte_no);

    // 레시피 문의
    public  void recipeInquiry(int recipte_no, Model model);
    // 레시피 문의 작성
    public  void inquirysave(HttpServletRequest request);
    // 레시피 문의 리스트
    public  void inquirylist(int write_no, Model model);

    // 레시피 답변할 리스트
    public void answerlist(int awnser_no, Model model);


    // 레시피 문의 상세
    public  void inquirydetail(int recipte_no, int write_no, int awnser_no,Model model);

    public  void  answerForm(int recipte_no, int write_no, int awnser_no,Model model);

    // 답변 하기
    public  void answer(HttpServletRequest request);
}
