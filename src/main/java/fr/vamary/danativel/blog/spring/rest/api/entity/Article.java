package fr.vamary.danativel.blog.spring.rest.api.entity;

import jakarta.persistence.*;
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

    private String title;

    private String description;

    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @CreationTimestamp
    private Instant created;

    @UpdateTimestamp
    private Instant updated;

}
