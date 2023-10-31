package weijuly.enterprise.bookstore.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import weijuly.enterprise.bookstore.data.entity.AuthorGenreEntity;

import java.util.Optional;

@Repository
public interface AuthorGenreRepository extends CrudRepository<AuthorGenreEntity, String> {

    Optional<AuthorGenreEntity> findByAuthorIdAndGenreId(String authorId, String genreId);
}
