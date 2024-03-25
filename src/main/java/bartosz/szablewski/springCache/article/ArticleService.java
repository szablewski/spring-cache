package bartosz.szablewski.springCache.article;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository repository;

    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    @Cacheable("article")
    public Article findById(final Long articleId) {
        return repository.findById(articleId).orElseThrow(RuntimeException::new);
    }

    @Cacheable("articles")
    public List<Article> findAllArticle() {
        return repository.findAllArticle();
    }
}
