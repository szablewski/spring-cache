package bartosz.szablewski.springCache.article;

import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Article>> findAllArticle() {
        val articles = articleService.findAllArticle();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping("/{articleId}")
    ResponseEntity<Article> findAllArticle(@PathVariable Long articleId) {
        val articles = articleService.findById(articleId);
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
}
