package ra.service.book;

import ra.dao.bookDao.BookDao;
import ra.dao.bookDao.IBookDao;
import ra.model.Book;

import java.util.Collections;
import java.util.List;

public class BookService implements IBookService {
    IBookDao bookDao = new BookDao();

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book finById(Integer id) {
        return bookDao.finById(id);
    }

    @Override
    public void save(Book book) {
        if (finById(book.getId()) != null) {
            bookDao.update(book);
        } else bookDao.create(book);

    }

    @Override
    public Object delete(Integer id) {
        bookDao.delete(id);
        return null;
    }
}
