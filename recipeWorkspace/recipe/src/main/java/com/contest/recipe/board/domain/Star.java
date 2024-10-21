package com.contest.recipe.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Star {

    private  int star_no; // 별점 번호
    private int  recipte_no; // 레시피 번호
    private int member_no; // 작성자 번호
    private int scope; // 별점

}
