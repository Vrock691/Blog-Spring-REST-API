package fr.vamary.danativel.blog.spring.rest.api.repository;

import fr.vamary.danativel.blog.spring.rest.api.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>
{
    Article getArticleBy(long id);
}
