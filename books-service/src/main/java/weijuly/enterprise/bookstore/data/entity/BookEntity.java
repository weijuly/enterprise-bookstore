package weijuly.enterprise.bookstore.data.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import weijuly.enterprise.bookstore.data.UUIDSequenceGenerator;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Accessors(fluent = true, chain = true)
@Table(name = "BOOK")
public class BookEntity implements Serializable {

    @Id
    @Column(name = "ID")
    @GenericGenerator(name = "bookId", type = UUIDSequenceGenerator.class)
    @GeneratedValue(generator = "bookId")
    private String id;

    @Column(name = "ISBN", nullable = false, unique = true)
    String isbn;

    @Column(name = "TITLE", nullable = false)
    String title;

    @Column(name = "SUMMARY", nullable = false)
    String summary;

    @Column(name = "PUBLISHED_ON", nullable = false)
    Integer publishedOn;

    @Column(name = "PAGES", nullable = false)
    Integer pages;
}
