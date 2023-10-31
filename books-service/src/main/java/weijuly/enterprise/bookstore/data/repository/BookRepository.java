package weijuly.enterprise.bookstore.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import weijuly.enterprise.bookstore.data.entity.BookEntity;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {
    Optional<BookEntity> findByIsbn(String isbn);
}
