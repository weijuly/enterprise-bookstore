package weijuly.enterprise.bookstore.transformer;

import weijuly.enterprise.bookstore.data.entity.BibliographyEntity;

public class BibliographyTransformer {

    public static BibliographyEntity transform(String authorId, String bookId) {
        return new BibliographyEntity()
                .authorId(authorId)
                .bookId(bookId);
    }
}
