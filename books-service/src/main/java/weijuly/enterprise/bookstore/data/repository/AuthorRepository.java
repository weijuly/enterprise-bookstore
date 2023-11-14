package weijuly.enterprise.bookstore.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import weijuly.enterprise.bookstore.data.entity.AuthorEntity;

import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<AuthorEntity, String> {

    Optional<AuthorEntity> findByName(String name);
}
