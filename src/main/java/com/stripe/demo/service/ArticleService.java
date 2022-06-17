package com.stripe.demo.service;

import com.stripe.demo.model.Article;
import com.stripe.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    public List<Article> list(){
        return articleRepository.findAll();
    }

    public Optional<Article> getById(long id){
        return articleRepository.findById(id);
    }

    public boolean existId(long id){
        return articleRepository.existsById(id);
    }
}
