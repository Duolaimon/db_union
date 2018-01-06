package db_union.question.controller;

import db_union.question.model.Question;
import db_union.question.service.IQuestionService;
import db_union.utils.Page;
import db_union.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by cirno
 * on 2017/7/5.
 */
@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {

    private IQuestionService iQuestionService;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public void setiQuestionService(IQuestionService iQuestionService) {
        this.iQuestionService = iQuestionService;
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Integer insert(Question question){
        return iQuestionService.insertQuestion(question);
    }

    @RequestMapping("/findQuestionById")
    public Question findQuestionById(Integer id){
        return iQuestionService.findQuestionById(id);
    }

    @RequestMapping("/findQuestionByPage")
    public List findQuestionByPage(Integer count){
        Page page = PageUtil.createPage(10,iQuestionService.countAll(),count);
        List list = iQuestionService.findQuestionByPage(page);
        list.add(page);
        return list;
    }
}
