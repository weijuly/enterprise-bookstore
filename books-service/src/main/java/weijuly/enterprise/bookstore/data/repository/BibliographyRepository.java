package weijuly.enterprise.bookstore.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import weijuly.enterprise.bookstore.data.entity.BibliographyEntity;

@Repository
public interface BibliographyRepository extends CrudRepository<BibliographyEntity, String> {
}
