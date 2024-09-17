package ra.dao.categoryDao;

import ra.model.Category;
import ra.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryDao implements ICategoryDao {
    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        Connection conn = ConnectionDB.getconnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conn.prepareCall("select * from category");
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("status")
                );
                list.add(category);

            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public Category finById(Integer id) {
        Connection conn = ConnectionDB.getconnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conn.prepareCall("select * from category where id=?");
            callableStatement.setInt(1, id);

            ResultSet rs = callableStatement.executeQuery();
            if (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("status")
                );
                return category;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return null;
    }

    @Override
    public void create(Category category) {
        Connection conn = ConnectionDB.getconnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conn.prepareCall("insert  into  category(name,status) values (?,?)");

            callableStatement.setString(1, category.getName());
            callableStatement.setBoolean(2, category.isStatus());
            callableStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void update(Category category) {
        Connection conn = ConnectionDB.getconnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conn.prepareCall("update category set name=? where  id=?");
            callableStatement.setString(1, category.getName());
            callableStatement.setInt(2, category.getId());
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void delete(Integer id) {
        Connection conn = ConnectionDB.getconnection();
        CallableStatement callableStatement = null;
        try {
            callableStatement = conn.prepareCall("delete from category where id=?");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }

    }
}
