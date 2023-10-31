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
@Table(name = "BOOK_GENRE")
public class BookGenreEntity {

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "bookGenreId", type = UUIDSequenceGenerator.class)
    @GeneratedValue(generator = "bookGenreId")
    private String id;

    @Column(name = "BOOK_ID", nullable = false)
    private String bookId;

    @Column(name = "GENRE_ID", nullable = false)
    private String genreId;

}
