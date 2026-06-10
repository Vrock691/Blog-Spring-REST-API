package fr.vamary.danativel.blog.spring.rest.api.controller;

import fr.vamary.danativel.blog.spring.rest.api.dto.ArticleDTO;
import fr.vamary.danativel.blog.spring.rest.api.service.ArticleDoesNotExistException;
import fr.vamary.danativel.blog.spring.rest.api.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public Page<ArticleDTO> getArticles(Pageable pageable) {
        return articleService.getArticles(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getArticle(@PathVariable long id) {
        return ResponseEntity.ok(articleService.getArticle(id));
    }

    @PostMapping("/")
    public ResponseEntity<ArticleDTO> createArticle(@RequestBody ArticleDTO articleDTO) {
        return new ResponseEntity<>(articleService.createArticle(articleDTO), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateArticle(@PathVariable long id, @RequestBody ArticleDTO articleDTO) {
        return ResponseEntity.ok(articleService.updateArticle(id, articleDTO));
    }

    @DeleteMapping("/{id}")
    @ExceptionHandler(ArticleDoesNotExistException.class)
    public ResponseEntity<?> deleteArticle(@PathVariable long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.ok().build();
    }

}
