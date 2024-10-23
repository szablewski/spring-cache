package bartosz.szablewski.cache.article;

import bartosz.szablewski.cache.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long articleId;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
    private LocalDate created;
    private LocalDate updated;
}