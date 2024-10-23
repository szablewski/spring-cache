package bartosz.szablewski.cache.article;

import bartosz.szablewski.cache.exception.EntityNotFound;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository repository;

    @Cacheable(value = "article", key = "#articleId")
    public Article findById(final Long articleId) {
        return repository.findById(articleId).orElseThrow(() -> new EntityNotFound("article", articleId));
    }

    @Cacheable(value = "article")
    public List<Article> findAllArticle() {
        return repository.findAllArticle();
    }

    @Caching(evict = {
            @CacheEvict(value = "article", allEntries = true),
            @CacheEvict(value = "article", key = "#articleId")})
    public void deleteArticle(final Long articleId) {

        repository.deleteById(articleId);
        log.info("Delete article by id: {}", articleId);
    }
}
