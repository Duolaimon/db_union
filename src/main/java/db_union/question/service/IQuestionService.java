package db_union.question.service;

import db_union.question.model.Question;
import db_union.utils.Page;

import java.util.List;

/**
 * Created by cirno
 * on 2017/7/5.
 */
public interface IQuestionService {

    Integer insertQuestion(Question question);

    Question findQuestionById(Integer id);

    Integer countAll();

    List findQuestionByPage(Page page);
}
