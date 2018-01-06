package db_union.question.service.impl;

import db_union.question.dao.QuestionMapper;
import db_union.question.model.Question;
import db_union.question.service.IQuestionService;
import db_union.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cirno
 * on 2017/7/5.
 */
@Service
public class QuestionServiceImpl implements IQuestionService {

    private QuestionMapper questionMapper;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setQuestionMapper(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public Integer insertQuestion(Question question) {
        return questionMapper.insert(question);
    }

    @Override
    public Question findQuestionById(Integer id)
    {
        return questionMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer countAll()
    {
        return questionMapper.countAll();
    }

    @Override
    public List findQuestionByPage(Page page) {
        return questionMapper.findQuestionByPage(page);
    }
}
