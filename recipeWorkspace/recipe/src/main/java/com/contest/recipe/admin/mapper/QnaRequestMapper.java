package com.contest.recipe.admin.mapper;

import com.contest.recipe.admin.vo.QnaRequestVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

/**
 * Q&A 요청목록 매퍼ㅇ
 */
@Mapper
public interface QnaRequestMapper {
    /**
     * INSERT - 한 행 삽입
     * <li>아마 QnaRequestVo 필드 중 qnaRequestNo 제외 null 인 놈이 있으면 튕길거</li>
     * @param vo 삽입할 VO객체dd
     * @return 성공여부
     */
    @Insert("""
            INSERT INTO QNA_REQUEST
            VALUES (
                SEQ_QNA_REQUEST_NO.NEXTVAL,
                #{qnaCategoryNo},
                #{qnaRequestCreatedDate},
                #{qnaRequestLastActivityDate},
                #{memberNo},
                #{qnaRequestStatus},
                #{qnaRequestTitle}
            )
            """)
    Boolean insert_rowAll(QnaRequestVo vo);

    /**
     * SELECT - qnaRequestNo 값으로 한 행 가져오기
     * @param qnaRequestNo 목표 행의 PK
     * @return QnaRequestVo - 조회 성공시 뭔가가 있는 객체, 실패시 아마 null
     */
    @Select("""
            SELECT *
            FROM QNA_REQUEST
            WHERE QNA_REQUEST_NO = #{qnaRequestNo}
            """)
    QnaRequestVo select_rowSpecific_all(Integer qnaRequestNo);

    /**
     * UPDATE - 한 행의 모든 값 덮어씌우기
     * <li>QNA_REQUEST_NO 는 수정할 수 없으며 해당 값이 없으면 실패함 실패할거임 아마</li>
     * @param vo 덮어씌울 행의 PK와 덮어씌울 정보들
     * @return 영향받은 행 개수 - 값이 null, 0 이거나 2 이상이면 뭔가 잘못된거
     */
    @Update("""
            UPDATE
                QNA_REQUEST
            SET
                QNA_CATEGORY_NO = #{qnaCategoryNo},
                QNA_REQUEST_CREATED_DATE = #{qnaRequestCreatedDate},
                QNA_REQUEST_LAST_ACTIVITY_DATE = #{qnaRequestLastActivityDate},
                MEMBER_NO = #{memberNo},
                QNA_REQUEST_STATUS = #{qnaRequestStatus},
                QNA_REQUEST_TITLE = #{qnaRequestTitle}
            WHERE
                QNA_REQUEST_NO = #{qnaRequestNo}
            """)
    Integer update_rowSpecific_all(QnaRequestVo vo);

    /*
        delete문은 나중에 씀
        qna_reply를 봐줘야되서 일단 미룬드
     */

    @Select("""
            SELECT
                QNA_REQUEST_NO,
                CAT.QNA_CATEGORY_NAME AS QNA_CATEGORY_NAME,
                QNA_REQUEST_TITLE,
                MEM.ID AS ID,
                TO_CHAR(QNA_REQUEST_CREATED_DATE, 'YY-MM-DD') AS QNA_REQUEST_CREATED_DATE,
                TO_CHAR(QNA_REQUEST_LAST_ACTIVITY_DATE, 'YY-MM-DD') AS QNA_REQUEST_LAST_ACTIVITY_DATE
            FROM
                QNA_REQUEST REQ
            INNER JOIN
                QNA_CATEGORY CAT ON REQ.QNA_CATEGORY_NO = CAT.QNA_CATEGORY_NO
            INNER JOIN
                MEMBER MEM ON REQ.MEMBER_NO = MEM.NO
            WHERE
                    QNA_REQUEST_STATUS = 0
                AND
                    ROWNUM <= 10
            ORDER BY
                QNA_REQUEST_NO DESC
            """)
    List<HashMap<String, Object>> select_recentTen();
}
