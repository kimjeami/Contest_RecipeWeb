package com.contest.recipe.board.service;

import com.contest.recipe.board.domain.Recipe;
import com.contest.recipe.board.domain.Recipe_inquiry;
import com.contest.recipe.board.repository.BoardRepository;
import com.contest.recipe.board.repository.Recipe_inquiryRepository;
import com.contest.recipe.util.U;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Value("${pagination.write_pages}")
    private int WRITE_PAGES;
    @Value("${pagination.page_rows}")
    private int PAGE_ROWS;



    private BoardRepository boardRepository;

    @Autowired
    private Recipe_inquiryRepository recipe_inquiryRepository;

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
                imagePaths.append(imgPath).append("-"); // 이미지 경로를 구분자로 결합
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
            combinedIngredients1.append(thingsNames[i]).append("-");
        }
        for (int i = 0; i < eas.length; i++) {
            combinedIngredients2.append(eas[i]).append("-");
        }
        for (int i = 0; i < thingsUrls.length; i++) {
            combinedIngredients3.append(thingsUrls[i]).append("-");
        }
        recipe.setThings_name(combinedIngredients1.toString());
        recipe.setEa(combinedIngredients2.toString());
        recipe.setThings_url(combinedIngredients3.toString());

        // 요리 순서 처리
        String[] explanations = mul.getParameterValues("explanation[]");

        StringBuilder combinedSteps = new StringBuilder();
        for (int i = 0; i < explanations.length; i++) {
            combinedSteps.append(explanations[i]).append("-");
        }
        recipe.setExplanation(combinedSteps.toString());

        // 레시피 저장
        boardRepository.Recipesave(recipe);
    }

    // 레시피 목록 가져오기
    @Override
    public void recipeList(Model model,String keyword, Integer page) {
        if (page == null) page = 1;   // 디폴트 1 page
        if (page < 1) page = 1;

        // paging
        HttpSession session = U.getSession();
        Integer writePages = (Integer) session.getAttribute("writePages");
        if (writePages == null) writePages = WRITE_PAGES;  // 만약 session 에 없으면 기본값으로 동작
        Integer pageRows = (Integer) session.getAttribute("pageRows");
        if (pageRows == null) pageRows = PAGE_ROWS; // 만약 session 에 없으면 기본값으로 동작
        session.setAttribute("page", page);  // 현재 페이지 번호 -> session 에 저장

        long cnt;
        int totalPage = 0;
        int startPage;
        int endPage;

        List<Recipe> list;

        cnt = boardRepository.countRecipe(keyword);
        list = boardRepository.recipeList(keyword,(page - 1) * pageRows, pageRows);

        totalPage = (int) Math.ceil(cnt / (double) pageRows);
        startPage = (((page - 1) / writePages) * writePages) + 1;
        endPage = startPage + writePages - 1;


        model.addAttribute("recipe",list);
        model.addAttribute("page", page); // 현재 페이지
        model.addAttribute("totalPage", totalPage);  // 총 '페이지' 수
        model.addAttribute("pageRows", pageRows);  // 한 '페이지' 에 표시할 글 개수

        model.addAttribute("url", U.getRequest().getRequestURI());  // 목록 url
        model.addAttribute("writePages", writePages); // [페이징] 에 표시할 숫자 개수
        model.addAttribute("startPage", startPage);  // [페이징] 에 표시할 시작 페이지
        model.addAttribute("endPage", endPage);   // [페이징] 에 표시할 마지막 페이지
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

        StringBuilder combinedIngredients1 = new StringBuilder();
        StringBuilder combinedIngredients2 = new StringBuilder();
        StringBuilder combinedIngredients3 = new StringBuilder();

        for (int i = 0; i < thingsNames.length; i++) {
            combinedIngredients1.append(thingsNames[i]).append("-");
        }
        for (int i = 0; i < eas.length; i++) {
            combinedIngredients2.append(eas[i]).append("-");
        }
        for (int i = 0; i < thingsUrls.length; i++) {
            combinedIngredients3.append(thingsUrls[i]).append("-");
        }
        recipe.setThings_name(combinedIngredients1.toString());
        recipe.setEa(combinedIngredients2.toString());
        recipe.setThings_url(combinedIngredients3.toString());

        // 요리 순서 처리
        String[] explanations = mul.getParameterValues("explanation[]");

        StringBuilder combinedSteps = new StringBuilder();
        for (int i = 0; i < explanations.length; i++) {
            combinedSteps.append(explanations[i]).append("-");
        }
        recipe.setExplanation(combinedSteps.toString());

        // 레시피 수정
        boardRepository.modify(recipe);
    }

    // 레시피 삭제


    @Override
    public int recipeDelete(int recipte_no) {
        int result = boardRepository.recipeDelete(recipte_no);
        return result;
    }


    //레시피 문의하기


    @Override
    public void recipeInquiry(int recipte_no, Model model) {
        Recipe recipe = boardRepository.recipeInquiry(recipte_no);
        model.addAttribute("recipe",recipe);
    }

    // 글 등록


    @Override
    public void inquirysave(HttpServletRequest request) {
        Recipe_inquiry recipe_inquiry = new Recipe_inquiry();

        recipe_inquiry.setRecipte_no(Integer.parseInt(request.getParameter("recipte_no")));
        recipe_inquiry.setWrite_no(Integer.parseInt(request.getParameter("write_no")));
        recipe_inquiry.setAwnser_no(Integer.parseInt(request.getParameter("awnser_no")));
        recipe_inquiry.setTitle(request.getParameter("title"));
        recipe_inquiry.setContent(request.getParameter("content"));

        recipe_inquiryRepository.inquirysave(recipe_inquiry);

    }
    // 레시피 문의 리스트
    @Override
    public void inquirylist(int write_no, Model model) {

        model.addAttribute("recipe_inquiry",recipe_inquiryRepository.inquirylist(write_no));

    }


    // 레시피 답변할 리스트

    @Override
    public void answerlist(int awnser_no, Model model) {
        model.addAttribute("recipe_inquiry",recipe_inquiryRepository.answerlist(awnser_no));
    }


    // 레시피 문의 상세보기

    @Override
    public void inquirydetail(int recipte_no, int write_no, int awnser_no, Model model) {
        Recipe_inquiry recipe_inquiry = recipe_inquiryRepository.inquirydetail(recipte_no,write_no,awnser_no);

        model.addAttribute("recipe_inquiry",recipe_inquiry);
    }

    // 레시피 답변
    @Override
    public void answerForm(int recipte_no, int write_no, int awnser_no, Model model) {
        Recipe_inquiry recipe_inquiry = recipe_inquiryRepository.inquirydetail(recipte_no,write_no,awnser_no);

        model.addAttribute("recipe_inquiry",recipe_inquiry);

    }

    // 답변 하기

    @Override
    public void answer(HttpServletRequest request) {
        Recipe_inquiry recipe_inquiry = new Recipe_inquiry();

        recipe_inquiry.setRecipte_no(Integer.parseInt(request.getParameter("recipte_no")));
        recipe_inquiry.setAwnser_no(Integer.parseInt(request.getParameter("awnser_no")));
        recipe_inquiry.setWrite_no(Integer.parseInt(request.getParameter("write_no")));
        recipe_inquiry.setAnswer(request.getParameter("answer"));

        recipe_inquiryRepository.answer(recipe_inquiry);
    }
}



