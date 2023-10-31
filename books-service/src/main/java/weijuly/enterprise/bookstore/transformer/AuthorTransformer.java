package weijuly.enterprise.bookstore.transformer;

import weijuly.enterprise.bookstore.data.entity.AuthorEntity;
import weijuly.enterprise.bookstore.model.Author;

public class AuthorTransformer {

    public static AuthorEntity transform(Author author) {
        return new AuthorEntity()
                .id(author.getId())
                .fullName(author.getName())
                .about(author.getAbout());
    }
}
