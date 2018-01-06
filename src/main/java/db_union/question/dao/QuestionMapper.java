package db_union.question.dao;

import db_union.question.model.Question;
import db_union.utils.Page;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    int countAll();

    List findQuestionByPage(Page page);
}