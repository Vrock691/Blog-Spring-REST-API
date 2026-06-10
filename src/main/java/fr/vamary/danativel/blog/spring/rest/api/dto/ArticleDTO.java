package fr.vamary.danativel.blog.spring.rest.api.dto;

import fr.vamary.danativel.blog.spring.rest.api.entity.User;
import lombok.Data;

import java.time.Instant;

@Data
public class ArticleDTO {
    private Long id;
    private String title;
    private String description;
    private String content;
    private User author;
    private Instant created;
    private Instant updated;
}
