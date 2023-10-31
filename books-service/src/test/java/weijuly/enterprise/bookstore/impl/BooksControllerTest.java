package weijuly.enterprise.bookstore.impl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weijuly.enterprise.bookstore.model.Book;
import weijuly.enterprise.bookstore.service.BooksService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BooksControllerTest {

    @Mock
    private BooksService service;

    @InjectMocks
    private BooksController controller;

    @BeforeEach
    public void beforeEach() {
        when(service.add(any(Book.class))).thenReturn(new Book());
    }

    @Test
    public void test() {
        assertNotNull(controller.addBook(new Book()));
    }

}