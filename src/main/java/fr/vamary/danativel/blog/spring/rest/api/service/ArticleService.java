package fr.vamary.danativel.blog.spring.rest.api.service;

import fr.vamary.danativel.blog.spring.rest.api.dto.ArticleDTO;
import fr.vamary.danativel.blog.spring.rest.api.dto.ArticleMapper;
import fr.vamary.danativel.blog.spring.rest.api.entity.Article;
import fr.vamary.danativel.blog.spring.rest.api.exception.ArticleDoesNotExistException;
import fr.vamary.danativel.blog.spring.rest.api.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleMapper articleMapper;

    public ArticleDTO getArticle(long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new NullPointerException("Article not found"));
        return articleMapper.toDto(article);
    }

    public Page<ArticleDTO> getArticles(Pageable pageable) {
        return articleRepository.findAll(pageable).map(articleMapper::toDto);
    }

    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        Article article = articleMapper.toEntity(articleDTO);
        articleRepository.save(article);
        return articleMapper.toDto(article);
    }

    public ArticleDTO updateArticle(Long id, ArticleDTO articleDetails) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new NullPointerException("Article not found"));

        article.setTitle(articleDetails.getTitle());
        article.setDescription(articleDetails.getDescription());
        article.setContent(articleDetails.getContent());

        articleRepository.save(article);

        return articleMapper.toDto(article);
    }

    public void deleteArticle(long id) throws ArticleDoesNotExistException {
        articleRepository.findById(id).orElseThrow(ArticleDoesNotExistException::new);
        articleRepository.deleteById(id);
    }

}
