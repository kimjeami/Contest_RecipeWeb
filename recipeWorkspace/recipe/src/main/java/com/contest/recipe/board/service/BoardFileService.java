package com.contest.recipe.board.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;

public interface BoardFileService {

    public static String IMAGE_REPO = Paths.get(System.getProperty("user.dir"), "src/main/resources/static/images").toString();
    public String saveFile1(MultipartFile file);

    public String saveFile2(MultipartFile file);


}
