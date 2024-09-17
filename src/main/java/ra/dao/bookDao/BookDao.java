package ra.dao.bookDao;

import ra.dao.categoryDao.ICategoryDao;
import ra.model.Book;
import ra.model.Category;
import ra.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookDao implements IBookDao {
    private ICategoryDao categoryDao;

    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        Connection conn = ConnectionDB.getconnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conn.prepareCall("select  * from book");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Category category = categoryDao.finById(rs.getInt("categoryId"));
                Book book = new Book(
                        rs.getInt("id"),
                        category,
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("totalPages"),
                        rs.getInt("yearCreated"),
                        rs.getString("author"),
                        rs.getBoolean("status")

                );
                list.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return list;
    }

    @Override
    public Book finById(Integer id) {
        Connection conn = ConnectionDB.getconnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conn.prepareCall("select * from book where id=?");
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            if (rs.next()) {
                Category category = categoryDao.finById(rs.getInt("categoryId"));

                Book book = new Book(
                        rs.getInt("id"),
                        category,
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getInt("totalPages"),
                        rs.getInt("yearCreated"),
                        rs.getString("author"),
                        rs.getBoolean("status")
                );
                return book;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return null;
    }

    @Override
    public void create(Book book) {
        Connection conn = ConnectionDB.getconnection();
        CallableStatement callableStatement = null;
        try {

            callableStatement = conn.prepareCall("insert into book (name, price, stock, " +
                    "totalPages, yearCreated, author," +
                    " status, categoryId) values (?,?,?,?,?,?,?,?)");
            callableStatement.setString(1, book.getName());
            callableStatement.setDouble(2, book.getPrice());
            callableStatement.setInt(3, book.getStock());
            callableStatement.setInt(4, book.getTotalPages());
            callableStatement.setInt(5, book.getYearCreated());
            callableStatement.setString(6, book.getAuthor());
            callableStatement.setBoolean(7, book.isStatus());
            callableStatement.setInt(8, book.getCategoryId().getId());
            callableStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }

    }

    @Override
    public void update(Book book) {
        Connection conn = ConnectionDB.getconnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conn.prepareCall("update book set name =?, price =?, " +
                    "stock =?, totalPages =?, yearCreated =?, author =?, status =?, categoryId =?" +
                    " where id =?");
            callableStatement.setString(1, book.getName());
            callableStatement.setDouble(2, book.getPrice());
            callableStatement.setInt(3, book.getStock());
            callableStatement.setInt(4, book.getTotalPages());
            callableStatement.setInt(5, book.getYearCreated());
            callableStatement.setString(6, book.getAuthor());
            callableStatement.setBoolean(7, book.isStatus());
            callableStatement.setInt(8, book.getCategoryId().getId());
            callableStatement.setInt(9, book.getId());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(conn);
        }

    }


    @Override
    public void delete(Integer id) {
        Connection conn = ConnectionDB.getconnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conn.prepareCall("delete from book where id=?");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }


    }
}
