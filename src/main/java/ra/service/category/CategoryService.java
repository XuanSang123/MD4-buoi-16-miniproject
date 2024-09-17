package ra.service.category;

import ra.dao.categoryDao.CategoryDao;
import ra.model.Category;

import java.util.List;

public class CategoryService implements ICategoryService {
    CategoryDao categoryDao = new CategoryDao();

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category finById(Integer id) {
        return categoryDao.finById(id);
    }

    @Override
    public void save(Category category) {
        if (finById(category.getId()) != null) {
            categoryDao.update(category);
        } else categoryDao.create(category);

    }

    @Override
    public Object delete(Integer id) {
        categoryDao.delete(id);


        return null;
    }
}
