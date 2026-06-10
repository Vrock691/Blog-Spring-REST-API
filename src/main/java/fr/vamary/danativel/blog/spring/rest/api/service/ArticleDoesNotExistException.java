package fr.vamary.danativel.blog.spring.rest.api.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Id of article does not exist")
public class ArticleDoesNotExistException extends RuntimeException {

    public ArticleDoesNotExistException() {
        super("Article doesn't exist");
    }

}
