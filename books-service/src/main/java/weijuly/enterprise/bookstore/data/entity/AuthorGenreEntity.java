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
@Table(name = "AUTHOR_GENRE")
public class AuthorGenreEntity {

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "authorGenreId", type = UUIDSequenceGenerator.class)
    @GeneratedValue(generator = "authorGenreId")
    private String id;

    @Column(name = "AUTHOR_ID", nullable = false)
    private String authorId;

    @Column(name = "GENRE_ID", nullable = false)
    private String genreId;

}
