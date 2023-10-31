package weijuly.enterprise.bookstore.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import weijuly.enterprise.bookstore.data.UUIDSequenceGenerator;

@Entity
@Getter
@Setter
@Accessors(fluent = true, chain = true)
@Table(name = "BIBLIOGRAPHY")
public class BibliographyEntity {

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "bibliographyId", type = UUIDSequenceGenerator.class)
    @GeneratedValue(generator = "bibliographyId")
    private String id;

    @Column(name = "BOOK_ID", nullable = false, unique = true)
    private String bookId;

    @Column(name = "AUTHOR_ID", nullable = false, unique = true)
    private String authorId;

}
