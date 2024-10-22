package com.contest.recipe.board.service;

import com.contest.recipe.board.domain.Star;
import com.contest.recipe.board.repository.StarRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class StarServicelmpl implements  StarService {

    @Autowired
    StarRepository starRepository;

    @Override
    public void write(HttpServletRequest request) {
        Star star = new Star();




        star.setRecipte_no(Integer.parseInt(request.getParameter("recipte_no")));
        star.setMember_no(Integer.parseInt(request.getParameter("member_no")));
        star.setScope(Integer.parseInt(request.getParameter("scope")));



        starRepository.starsave(star);
    }

    // 별점 업데이트
    @Override
    public void update(HttpServletRequest request) {

        Star star = new Star();

        star.setRecipte_no(Integer.parseInt(request.getParameter("recipte_no")));
        star.setMember_no(Integer.parseInt(request.getParameter("member_no")));
        star.setScope(Integer.parseInt(request.getParameter("scope")));


        starRepository.starupdate(star);
    }

    // 별점 가져오기
    @Override
    public Star getStar(int recipte_no, int member_no) {

        return starRepository.getStar(recipte_no,member_no);


    }
}
