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
@Table(name = "GENRE")
public class GenreEntity {
    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "genreId", type = UUIDSequenceGenerator.class)
    @GeneratedValue(generator = "genreId")
    private String id;

    @Column(name = "GENRE_NAME", nullable = false)
    private String genreName;

}
