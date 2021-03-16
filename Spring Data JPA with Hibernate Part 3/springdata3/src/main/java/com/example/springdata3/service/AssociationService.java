package com.example.springdata3.service;

import com.example.springdata3.entity.Address;
import com.example.springdata3.entity.Author;
import com.example.springdata3.entity.Book;
import com.example.springdata3.entity.Subject;
import com.example.springdata3.entity.manytomany.AuthorMany;
import com.example.springdata3.entity.manytomany.BookMany;
import com.example.springdata3.entity.onetoone.AuthorOne;
import com.example.springdata3.entity.onetoone.BookOne;
import com.example.springdata3.repository.AuthorManyRepository;
import com.example.springdata3.repository.AuthorRepository;
import com.example.springdata3.repository.BookOneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssociationService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorManyRepository authorManyRepository;

    @Autowired
    BookOneRepository bookOneRepository;

    public void createAuthor(){
        Author author = new Author();
        author.setName("Chetan Bhagat");

        Address address = new Address();
        address.setLocation("India");
        address.setState("Mumbai");
        address.setStreetNumber("144B");

        author.setAddress(address);

        List<Book> books = new ArrayList<Book>();

        Book book1 = new Book();
        book1.setBookName("One night");
        book1.setAuthor(author);
        books.add(book1);


        Book book2 = new Book();
        book2.setBookName("2 States");
        book2.setAuthor(author);
        books.add(book2);

        author.setBooks(books);

        List<Subject> subjects = new ArrayList<>();
        Subject subject1 = new Subject();
        subject1.setSubjectName("Mathematics");
        subject1.setAuthor(author);

        Subject subject2 = new Subject();
        subject2.setSubjectName("Science");
        subject2.setAuthor(author);

        Subject subject3 = new Subject();
        subject3.setSubjectName("History");
        subject3.setAuthor(author);

        subjects.add(subject1);
        subjects.add(subject2);

        author.setSubjectList(subjects);

        authorRepository.save(author);
    }

    public void createManyToMany(){
        AuthorMany auth = new AuthorMany();
        auth.setName("Khushwant Singh");
        List<BookMany> bookManyList = new ArrayList<BookMany>();

        BookMany bookMany = new BookMany();
        bookMany.setBookName("We Indians");
        bookManyList.add(bookMany);

        auth.setBooks(bookManyList);
        authorManyRepository.save(auth);
    }

    public void createOneToOne(){
        BookOne bookOne = new BookOne();
        bookOne.setBookName("Khushwant Singh");

        AuthorOne authorOne = new AuthorOne();
        authorOne.setName("Karma");
        bookOne.setAuthorOne(authorOne);

        bookOneRepository.save(bookOne);
    }
}
