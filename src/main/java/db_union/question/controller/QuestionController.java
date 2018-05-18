package db_union.question.controller;

import db_union.question.model.Question;
import db_union.question.service.IQuestionService;
import db_union.utils.Page;
import db_union.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/")
    public String noPage() {
        return "404";
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Integer insert(Question question){
        return iQuestionService.insertQuestion(question);
    }

    @GetMapping("/findQuestionById")
    public Question findQuestionById(Integer id){
        return iQuestionService.findQuestionById(id);
    }

    @GetMapping("/findQuestionByPage")
    public List findQuestionByPage(Integer count){
        Page page = PageUtil.createPage(10,iQuestionService.countAll(),count);
        List list = iQuestionService.findQuestionByPage(page);
        list.add(page);
        return list;
    }
}
