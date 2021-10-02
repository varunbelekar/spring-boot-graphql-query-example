package com.techprimers.graphql.springbootgrapqlexample.service.resolver;

import com.techprimers.graphql.springbootgrapqlexample.model.Book;
import com.techprimers.graphql.springbootgrapqlexample.repository.BookRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements DataFetcher<String> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public String get(DataFetchingEnvironment dataFetchingEnvironment) {
        Book book = new Book();
        String isn = dataFetchingEnvironment.getArgument("isn");
        String title = dataFetchingEnvironment.getArgument("title");
        String[] authors = dataFetchingEnvironment.getArgument("authors");
        String publisher = dataFetchingEnvironment.getArgument("publisher");
        String publishedDate = dataFetchingEnvironment.getArgument("publishedDate");
        book.setAuthors(authors);
        book.setTitle(title);
        book.setIsn(isn);
        book.setPublishedDate(publishedDate);
        book.setPublisher(publisher);
        bookRepository.save(book);
        return "Book created";
    }
}
