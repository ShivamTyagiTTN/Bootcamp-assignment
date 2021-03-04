package com.tothenew.springDemo.question4;

public class Book {
    private int bookId;
    private String bookName;
    private String author;


    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return "Book{ " +
                "bookId =" + bookId +
                ", bookName ='" + bookName + '\'' +
                ", Author ='" + author + '\'' +
                '}';
    }
}

