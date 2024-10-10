package com.contest.recipe.board.service;

import com.contest.recipe.board.domain.Recipe;
import com.contest.recipe.board.repository.BoardRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class BoardServiceImpl implements BoardService{



    private BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(SqlSession sqlSession){  // MyBatis 가 생성한 SqlSession 빈(bean) 객체 주입
        boardRepository = sqlSession.getMapper(BoardRepository.class);
        System.out.println("BoardService() 생성");
    }

    @Autowired
    private  BoardFileService bfs;


    // 레시피 작성하기
    @Override
    public void write(MultipartHttpServletRequest mul, HttpServletResponse response, HttpServletRequest request) {
        Recipe recipe = new Recipe();

        // 파일 처리
        MultipartFile file1 = mul.getFile("thumbnal");
        List<MultipartFile> recipeSeqImgs = mul.getFiles("recipe_seq_img[]");
        if (file1 != null && !file1.isEmpty()) {
            recipe.setThumbnail(bfs.saveFile1(file1));
        } else {
            recipe.setThumbnail("nan"); // 기본값 설정
        }

        // 여러 이미지 저장 처리
        if (recipeSeqImgs != null && !recipeSeqImgs.isEmpty()) {
            StringBuilder imagePaths = new StringBuilder();
            for (MultipartFile imgFile : recipeSeqImgs) {
                String imgPath = bfs.saveFile2(imgFile);
                imagePaths.append(imgPath).append(","); // 이미지 경로를 구분자로 결합
            }
            recipe.setRecipe_seq_img(imagePaths.toString()); // 경로를 문자열로 저장
        } else {
            recipe.setRecipe_seq_img("nan"); // 기본값 설정
        }

        // 레시피 기본 정보 설정
        recipe.setWrite_name(mul.getParameter("write_name"));
        recipe.setWrite_no(Integer.parseInt(mul.getParameter("write_no")));
        recipe.setTitle(mul.getParameter("title"));
        recipe.setIntroduce(mul.getParameter("introduce"));
        recipe.setRecipe_cate_no(Integer.parseInt(mul.getParameter("recipe_cate_no")));
        recipe.setServing(mul.getParameter("serving"));
        recipe.setTime_taken(mul.getParameter("time_taken"));
        recipe.setStep(mul.getParameter("step"));
        recipe.setTip(mul.getParameter("tip"));

        // 재료 정보 처리
        String[] thingsNames = mul.getParameterValues("things_name[]");
        String[] eas = mul.getParameterValues("ea[]");
        String[] thingsUrls = mul.getParameterValues("things_url[]");

        StringBuilder combinedIngredients1 = new StringBuilder();
        StringBuilder combinedIngredients2 = new StringBuilder();
        StringBuilder combinedIngredients3 = new StringBuilder();

        for (int i = 0; i < thingsNames.length; i++) {
            combinedIngredients1.append(thingsNames[i]).append(",");
        }
        for (int i = 0; i < eas.length; i++) {
            combinedIngredients2.append(eas[i]).append(",");
        }
        for (int i = 0; i < thingsUrls.length; i++) {
            combinedIngredients3.append(thingsUrls[i]).append(",");
        }
        recipe.setThings_name(combinedIngredients1.toString());
        recipe.setEa(combinedIngredients2.toString());
        recipe.setThings_url(combinedIngredients3.toString());

        // 요리 순서 처리
        String[] explanations = mul.getParameterValues("explanation[]");

        StringBuilder combinedSteps = new StringBuilder();
        for (int i = 0; i < explanations.length; i++) {
            combinedSteps.append(explanations[i]).append(",");
        }
        recipe.setExplanation(combinedSteps.toString());

        // 레시피 저장
        boardRepository.Recipesave(recipe);
    }

    // 레시피 목록 가져오기
    @Override
    public void recipeList(Model model) {
        model.addAttribute("recipe",boardRepository.recipeList());
    }

    // 레시피 상세정보 가져오기


    @Override
    public void recipeDetail(int recipte_no, Model model) {
        Recipe recipe = boardRepository.recipeDetail(recipte_no);
        model.addAttribute("recipe",recipe);

    }

    // 레시피 수정 페이지

    // 수정할 정보 가져오기
    @Override
    public void recipeModifyForm(int recipte_no, Model model) {
        Recipe recipe = boardRepository.recipeDetail(recipte_no);
        model.addAttribute("recipe",recipe);
    }

    // 레시피 수정
    @Override
    public void recipeMoidfy(MultipartHttpServletRequest mul, HttpServletRequest request) {
        Recipe recipe = new Recipe();

        // 이미지 파일 처리
        MultipartFile file1 = mul.getFile("thumbnal");
        List<MultipartFile> recipeSeqImgs = mul.getFiles("recipe_seq_img[]");
        if (file1 != null && !file1.isEmpty()) {
            recipe.setThumbnail(bfs.saveFile1(file1));
        } else {
            recipe.setThumbnail("nan"); // 기본값 설정
        }

        // 여러 이미지 저장 처리
        if (recipeSeqImgs != null && !recipeSeqImgs.isEmpty()) {
            StringBuilder imagePaths = new StringBuilder();
            for (MultipartFile imgFile : recipeSeqImgs) {
                String imgPath = bfs.saveFile2(imgFile);
                imagePaths.append(imgPath).append(","); // 이미지 경로를 구분자로 결합
            }
            recipe.setRecipe_seq_img(imagePaths.toString()); // 경로를 문자열로 저장
        } else {
            recipe.setRecipe_seq_img("nan"); // 기본값 설정
        }

        // 레시피 변경된 정보 저장
        recipe.setRecipte_no(Integer.parseInt(mul.getParameter("recipte_no")));
        recipe.setTitle(mul.getParameter("title"));
        recipe.setIntroduce(mul.getParameter("introduce"));
        recipe.setRecipe_cate_no(Integer.parseInt(mul.getParameter("recipe_cate_no")));
        recipe.setServing(mul.getParameter("serving"));
        recipe.setTime_taken(mul.getParameter("time_taken"));
        recipe.setStep(mul.getParameter("step"));
        recipe.setTip(mul.getParameter("tip"));

        // 재료 정보 처리
        String[] thingsNames = mul.getParameterValues("things_name[]");
        String[] eas = mul.getParameterValues("ea[]");
        String[] thingsUrls = mul.getParameterValues("things_url[]");

        StringBuilder combinedIngredients = new StringBuilder();
        for (int i = 0; i < thingsNames.length; i++) {
            combinedIngredients.append(thingsNames[i]).append(" - ").append(eas[i]).append(" - ").append(thingsUrls[i]).append(",");
        }
        recipe.setThings_name(combinedIngredients.toString());

        // 요리 순서 처리
        String[] explanations = mul.getParameterValues("explanation[]");

        StringBuilder combinedSteps = new StringBuilder();
        for (int i = 0; i < explanations.length; i++) {
            combinedSteps.append(explanations[i]).append(",");
        }
        recipe.setExplanation(combinedSteps.toString());

        // 레시피 수정
        boardRepository.modify(recipe);
    }
}



