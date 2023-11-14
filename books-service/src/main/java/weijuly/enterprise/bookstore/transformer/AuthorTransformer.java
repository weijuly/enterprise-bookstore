package weijuly.enterprise.bookstore.transformer;

import weijuly.enterprise.bookstore.data.entity.AuthorEntity;
import weijuly.enterprise.bookstore.model.Author;
import weijuly.enterprise.bookstore.model.proto.AuthorProto;

public class AuthorTransformer {

    public static AuthorEntity transform(Author author) {
        return new AuthorEntity()
                .id(author.getId())
                .name(author.getName())
                .about(author.getAbout());
    }

    public static AuthorProto proto(Author author) {
        return AuthorProto
                .newBuilder()
                .setName(author.getName())
                .setAbout(author.getAbout())
                .build();
    }
}
