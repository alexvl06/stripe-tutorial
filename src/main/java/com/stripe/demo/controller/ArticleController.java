package com.stripe.demo.controller;

import com.stripe.demo.http.Message;
import com.stripe.demo.model.Article;
import com.stripe.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin(origins = "*")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/list")
    public ResponseEntity<List<Article>> list(){
        return new ResponseEntity<List<Article>>(articleService.list(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Article> detail(@PathVariable("id") long id){
        if(!articleService.existId(id)) return new ResponseEntity(new Message("It does not exist"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<Article>(articleService.getById(id).get(), HttpStatus.OK);
    }
}
