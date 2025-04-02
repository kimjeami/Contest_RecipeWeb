package com.contest.recipe.mail.vo;

import lombok.Data;

@Data
public class MailVo {
    private String no;
    private String memberNo;
    private String authCode;
    private String isYn;
}
