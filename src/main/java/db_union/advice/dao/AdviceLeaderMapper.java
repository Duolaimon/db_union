package db_union.advice.dao;

import db_union.advice.model.Advice;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Duolaimon
 * 18-3-19 下午9:55
 */
public interface AdviceLeaderMapper {
    List<Advice> selectAdviceByLeaderId(Map map);

    int insertAdviceLeader(@Param("adviceId") Integer adviceId, @Param("leaderId") Integer leaderId);
}
