package fr.vamary.danativel.blog.spring.rest.api.dto;

import fr.vamary.danativel.blog.spring.rest.api.entity.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleDTO toDto(Article article);
    Article toEntity(ArticleDTO postDto);
}