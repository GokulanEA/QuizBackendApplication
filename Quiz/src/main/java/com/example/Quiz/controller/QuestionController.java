package com.example.Quiz.controller;

import com.example.Quiz.model.Question;
import com.example.Quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
     return questionService.getAllQuestions();
    }
    @GetMapping("category/{cate}")
    public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable("cate") String cate){
        return questionService.getAllQuestionsByCategory(cate);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
