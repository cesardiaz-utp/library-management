package com.devsenior.cdiaz.library.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.devsenior.cdiaz.library.model.Book;
import com.devsenior.cdiaz.library.model.Loan;
import com.devsenior.cdiaz.library.model.User;
import com.devsenior.cdiaz.library.repository.BookRepository;
import com.devsenior.cdiaz.library.repository.LoanRepository;

public class LibraryServiceMethodsTest {

    private BookRepository bookRepository;
    private LoanRepository loanRepository;
    private LibraryService libraryService;

    @BeforeEach
    void setUp() {
        bookRepository = Mockito.mock(BookRepository.class);
        loanRepository = Mockito.mock(LoanRepository.class);
        libraryService = new LibraryService(bookRepository, loanRepository);        
    }

    @Test
    void testAddBook() {
        var book = new Book(2, "Cien Años de Soledad", "Gabriel García Márquez");

        libraryService.addBook(book);

        Mockito.verify(bookRepository).save(book);
    }

    @Test
    void testGetBook() {
        var bookMock = new Book(1, "El Quijote", "Miguel de Cervantes");
        Mockito.when(bookRepository.findById(1)).thenReturn(bookMock);

        var book = libraryService.getBook(1);

        assertEquals("El Quijote", book.getTitle());
        assertEquals("Miguel de Cervantes", book.getAuthor());
    }

    @Test
    void testGetLoansByUser() {
        User user = new User(1, "Bob");
        Book book1 = new Book(1, "1984", "George Orwell");
        Book book2 = new Book(2, "Brave New World", "Aldous Huxley");
        Loan loan1 = new Loan(1, user, book1, LocalDate.of(2023, 1, 1));
        Loan loan2 = new Loan(2, user, book2, LocalDate.of(2023, 2, 1));

        List<Loan> loans = Arrays.asList(loan1, loan2);
        Mockito.when(loanRepository.findByUser(user)).thenReturn(loans);

        List<Loan> result = libraryService.getLoansByUser(user);

        assertEquals(2, result.size());
        assertEquals(loan1, result.get(0));
        assertEquals(loan2, result.get(1));
    }

    @Test
    void testLoanBook() {
        // Create a user and a book
        User user = new User(1, "Alice");
        Book book = new Book(1, "1984", "George Orwell");

        // Call the method to be tested
        libraryService.loanBook(user, book);

        // Verify that the save method of the loanRepository was called with the correct
        // loan
        Mockito.verify(loanRepository).save(Mockito.argThat(loan -> loan.getUser().equals(user) &&
                loan.getBook().equals(book) &&
                loan.getLoanDate().equals(LocalDate.now())));
    }
}
