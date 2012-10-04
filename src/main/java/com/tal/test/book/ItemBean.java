package com.tal.test.book;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public
@Model
class ItemBean {

    @Inject
    private LanguageSingleton languageSingleton;
    @Inject
    private BookKeeper bookKeeper;

    private Book book = new Book();
    private List<Book> bookList = new ArrayList<Book>();

    private String tags;
    private String languageCode;

    public ItemBean() {
    }

    public void process() {

    }

    @PostConstruct
    public void initBooks() {
        bookList = bookKeeper.getBooks();
    }

    public String doNewBookForm() {
        return "newBook.xhtml";
    }

    public void doCreateBook() {
        book.setTags(transformToList(tags));
        book.setContentLanguage(languageSingleton.getLanguageValue(languageCode));
        bookKeeper.addBook(book);
    }

    private List<String> transformToList(String tagsRequestParameter) {
        List<String> listOfTags = new ArrayList<String>();
        StringTokenizer tokens = new StringTokenizer(tagsRequestParameter, ",");
        while (tokens.hasMoreElements()) {
            listOfTags.add(((String) tokens.nextElement()).trim());
        }
        return listOfTags;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }
}
