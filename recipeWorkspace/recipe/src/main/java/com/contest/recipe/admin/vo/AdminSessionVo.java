package com.contest.recipe.admin.vo;

import com.contest.recipe.rank.vo.RankVo;
import lombok.Data;

import java.util.List;

/**
 * 관리자 로그인 시 세션에 관리자 계정 정보(AdminVo) 와 관리자에게 부여된 권한 리스트(List<RankVo>) 를 저장하기 위해 만든 클래스
 *
 * <li>Setter 는 안 넣었음, 값은 생성자로 넣어라 </li>
 * */
@Data
public class AdminSessionVo {
    private AdminVo adminVo;
    private List<RankVo> grantedRanks;
}