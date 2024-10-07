package com.contest.recipe.board.service;

import com.contest.recipe.board.domain.Recipte_comment;
import com.contest.recipe.board.repository.CommentRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(SqlSession sqlSession){  // MyBatis 가 생성한 SqlSession 빈(bean) 객체 주입
        commentRepository = sqlSession.getMapper(CommentRepository.class);
        System.out.println("CommentService() 생성");
    }


    @Override
    public void write(int recipte_no , String answer, String member_name,int scope) {
        Recipte_comment recipte_comment = new Recipte_comment();

        recipte_comment.setRecipte_no(recipte_no);
        recipte_comment.setAnswer(answer);
        recipte_comment.setMember_name(member_name);
        recipte_comment.setScope(scope);
        commentRepository.Commentsave(recipte_comment);


    }


    @Override
    public List<Recipte_comment> list(int recipte_no) {

       return commentRepository.Commentlist(recipte_no);


    }
}
