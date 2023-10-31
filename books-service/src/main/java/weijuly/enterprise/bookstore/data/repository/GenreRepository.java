package weijuly.enterprise.bookstore.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import weijuly.enterprise.bookstore.data.entity.GenreEntity;

import java.util.Optional;

@Repository
public interface GenreRepository extends CrudRepository<GenreEntity, String> {

    Optional<GenreEntity> findByGenreName(String genreName);

}
