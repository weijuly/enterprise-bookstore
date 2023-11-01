package weijuly.enterprise.bookstore.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weijuly.enterprise.bookstore.data.entity.*;
import weijuly.enterprise.bookstore.data.repository.*;
import weijuly.enterprise.bookstore.error.BookServiceException;
import weijuly.enterprise.bookstore.model.Author;
import weijuly.enterprise.bookstore.model.Book;
import weijuly.enterprise.bookstore.model.SearchBooks;
import weijuly.enterprise.bookstore.transformer.AuthorGenreTransformer;
import weijuly.enterprise.bookstore.transformer.BibliographyTransformer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static weijuly.enterprise.bookstore.transformer.AuthorTransformer.transform;
import static weijuly.enterprise.bookstore.transformer.BookTransformer.transform;
import static weijuly.enterprise.bookstore.transformer.GenreTransformer.transform;

@Service
public class BooksService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private BookGenreRepository bookGenreRepository;

    @Autowired
    private BibliographyRepository bibliographyRepository;

    @Autowired
    private AuthorGenreRepository authorGenreRepository;

    public SearchBooks search() {
        return new SearchBooks()
                .books(Collections.emptyList())
                .page(12)
                .total(12)
                .size(12);
    }

    @Transactional
    public Book add(Book book) {
        try {
            if (exists(book)) {
                throw new BookServiceException(HttpStatus.BAD_REQUEST, "Book already exists");
            }
            BookEntity bookEntity = addBook(book);
            List<AuthorEntity> authorEntities = updateAuthors(book.getAuthors());
            List<GenreEntity> genreEntities = updateGenres(book.getGenres());
            addBookGenres(
                    bookEntity.id(),
                    genreEntities
                            .stream()
                            .map(GenreEntity::id)
                            .collect(Collectors.toList()));
            addBibliographies(
                    bookEntity.id(),
                    authorEntities
                            .stream()
                            .map(AuthorEntity::id)
                            .collect(Collectors.toList()));
            updateAuthorsGenres(
                    authorEntities
                            .stream()
                            .map(AuthorEntity::id)
                            .collect(Collectors.toList()),
                    genreEntities
                            .stream()
                            .map(GenreEntity::id)
                            .collect(Collectors.toList())
            );
            return book;

        } catch (BookServiceException e) {
            return null;
        }
    }

    public Book getBookById(String id) {
        return bookRepository
                .findById(id)
                .map(this::somega)
                .orElseThrow(() -> new BookServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Book with id: %s not found", id)));
    }

    private Book somega(BookEntity e) {
        return new Book();
    }

    private boolean exists(Book book) {
        return bookRepository
                .findByIsbn(book.getIsbn())
                .isPresent();
    }

    private List<BookGenreEntity> addBookGenres(String bookId, List<String> genreIds) {
        return genreIds
                .stream()
                .map(genreId -> updateBookGenre(bookId, genreId))
                .collect(Collectors.toList());
    }

    private BookGenreEntity updateBookGenre(String bookId, String genreId) {
        return bookGenreRepository
                .save(new BookGenreEntity()
                        .bookId(bookId)
                        .genreId(genreId));
    }

    private List<BibliographyEntity> addBibliographies(String bookId, List<String> authorIds) {
        return authorIds
                .stream()
                .map(authorId -> updateBibliography(bookId, authorId))
                .collect(Collectors.toList());
    }

    private BibliographyEntity updateBibliography(String bookId, String authorId) {
        return bibliographyRepository
                .save(BibliographyTransformer.transform(authorId, bookId));
    }

    private List<AuthorGenreEntity> updateAuthorsGenres(List<String> authorIds, List<String> genreIds) {
        return authorIds
                .stream()
                .map(authorId -> updateAuthorGenres(authorId, genreIds))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<AuthorGenreEntity> updateAuthorGenres(String authorId, List<String> genreIds) {
        return genreIds
                .stream()
                .map(genreId -> updateAuthorGenre(authorId, genreId))
                .collect(Collectors.toList());
    }

    private AuthorGenreEntity updateAuthorGenre(String authorId, String genreId) {
        return authorGenreRepository
                .findByAuthorIdAndGenreId(authorId, genreId)
                .orElseGet(() -> authorGenreRepository.save(AuthorGenreTransformer.transform(authorId, genreId)));
    }

    private BookEntity addBook(Book book) {
        return bookRepository
                .save(transform(book));
    }

    private List<GenreEntity> updateGenres(List<String> genres) {
        return genres
                .stream()
                .map(String::toUpperCase)
                .map(this::updateGenre)
                .collect(Collectors.toList());
    }

    private GenreEntity updateGenre(String genre) {
        return genreRepository
                .findByGenreName(genre)
                .orElseGet(() -> genreRepository.save(transform(genre)));
    }


    private List<AuthorEntity> updateAuthors(List<Author> authors) {
        return authors
                .stream()
                .map(this::updateAuthor)
                .collect(Collectors.toList());
    }

    private AuthorEntity updateAuthor(Author author) {
        return authorRepository
                .findByFullName(author.getName())
                .orElseGet(() -> authorRepository.save(transform(author)));
    }
}
