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
@Table(name = "AUTHOR")
public class AuthorEntity {

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "authorId", type = UUIDSequenceGenerator.class)
    @GeneratedValue(generator = "authorId")
    private String id;

    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;

    @Column(name = "ABOUT", nullable = false)
    private String about;
}
