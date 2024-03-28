package bartosz.szablewski.springCache.article;

import bartosz.szablewski.springCache.exception.EntityNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ArticleService {

    private final ArticleRepository repository;

    public ArticleService(ArticleRepository repository) {
        this.repository = repository;
    }

    public Article findById(final Long articleId) {
        return repository.findById(articleId).orElseThrow(() -> new EntityNotFound("article", articleId));
    }

    @Cacheable(cacheNames = "articles")
    public List<Article> findAllArticle() {
        return repository.findAllArticle();
    }

    public void deleteArticle(final Long articleId) {
        Article result = findById(articleId);

        log.info("Delete article by id: {}", articleId);
        repository.delete(result);
    }
}
