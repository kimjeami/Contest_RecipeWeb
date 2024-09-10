package com.contest.recipe.board.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {

    public void write(MultipartHttpServletRequest mul, HttpServletResponse response,
                       HttpServletRequest request);

    public void recipeList(Model model);

}
