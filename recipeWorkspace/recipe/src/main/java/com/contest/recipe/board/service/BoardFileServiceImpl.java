package com.contest.recipe.board.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class BoardFileServiceImpl implements BoardFileService{

    public String saveFile1(MultipartFile file) {

        String sysFileName = file.getOriginalFilename();

        File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
        try {

            file.transferTo(saveFile);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return sysFileName;
    }

    public String saveFile2(MultipartFile file) {

        String sysFileName = file.getOriginalFilename();

        File saveFile = new File(IMAGE_REPO+"/"+sysFileName);
        try {

            file.transferTo(saveFile);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return sysFileName;
    }

}
