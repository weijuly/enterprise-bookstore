package weijuly.enterprise.bookstore.transformer;

import weijuly.enterprise.bookstore.data.entity.GenreEntity;

public class GenreTransformer {

    public static GenreEntity transform(String genreName) {
        return new GenreEntity()
                .genreName(genreName);
    }
}
