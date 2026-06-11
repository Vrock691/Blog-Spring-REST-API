package fr.vamary.danativel.blog.spring.rest.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Getter @Setter
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @Size(min = 10, max = 500, message = "Title must be at most 500 characters, and at least 10 characters.")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    @Size(min = 10, max = 500, message = "Description must be at most 500 characters, and at least 10 characters.")
    private String description;

    @NotBlank(message = "Content cannot be blank")
    @Size(min = 50, message = "Content must be at least 50 characters.")
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @CreationTimestamp
    private Instant created;

    @UpdateTimestamp
    private Instant updated;

}
