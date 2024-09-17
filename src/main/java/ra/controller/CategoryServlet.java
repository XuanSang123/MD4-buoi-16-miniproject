package ra.controller;

import ra.dao.categoryDao.CategoryDao;
import ra.dao.categoryDao.ICategoryDao;
import ra.model.Category;
import ra.service.category.CategoryService;
import ra.service.category.ICategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
    private ICategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "GETALL":
                    request.setAttribute("ca", categoryService.findAll());
                    request.getRequestDispatcher("/views/list-category.jsp").forward(request, response);
                    break;
                case "DETAIL":
                    Integer idD = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("ca", categoryService.finById(idD));
                    request.getRequestDispatcher("/views/detail-category.jsp").forward(request, response);
                    break;
                case "DELETE":
                    Integer idDel = Integer.valueOf(request.getParameter("id"));
                    categoryService.delete(idDel);
                    response.sendRedirect("/category?action=GETALL");
                    break;
                case "EDIT":
                    Integer idDetail = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("category", categoryService.finById(idDetail));
                    request.getRequestDispatcher("/views/edit-category.jsp").forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "UPDATE":
                    Category updateCategory = new Category(
                            Integer.parseInt(request.getParameter("id")),
                            request.getParameter("name"),
                            Boolean.parseBoolean(request.getParameter("status"))
                    );
                    categoryService.save(updateCategory);
                    response.sendRedirect("/category?action=GETALL");
                    break;
                case "ADD":
                    Category category = new Category(
                            0, request.getParameter("name"),
                            Boolean.parseBoolean(request.getParameter("status"))
                    );
                    categoryService.save(category);
                    response.sendRedirect("/category?action=GETALL");

            }
        }
    }
}