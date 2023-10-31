package weijuly.enterprise.bookstore.data.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import weijuly.enterprise.bookstore.data.entity.BookGenreEntity;

@Repository
public interface BookGenreRepository extends CrudRepository<BookGenreEntity, String> {
}
