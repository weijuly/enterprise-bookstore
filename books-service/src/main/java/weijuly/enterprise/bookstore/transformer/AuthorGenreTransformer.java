package weijuly.enterprise.bookstore.transformer;

import weijuly.enterprise.bookstore.data.entity.AuthorGenreEntity;

public class AuthorGenreTransformer {

    public static AuthorGenreEntity transform(String authorId, String genreId) {
        return new AuthorGenreEntity()
                .authorId(authorId)
                .genreId(genreId);
    }
}
