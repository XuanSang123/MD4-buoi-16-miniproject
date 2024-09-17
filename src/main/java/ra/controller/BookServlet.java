package ra.controller;

import ra.model.Book;
import ra.model.Category;
import ra.service.book.BookService;
import ra.service.book.IBookService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookServlet", value = "/books")
public class BookServlet extends HttpServlet {

    private IBookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "GETALL":
                    request.setAttribute("book", bookService.findAll());
                    request.getRequestDispatcher("/views/list-book.jsp").forward(request, response);
                    break;
                case "DETAIL":
                    Integer idD = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("book", bookService.finById(idD));
                    request.getRequestDispatcher("/views/detail-book.jsp").forward(request, response);
                    break;
                case "DELETE":
                    Integer idDel = Integer.valueOf(request.getParameter("id"));
                    bookService.delete(idDel);
                    response.sendRedirect("/books?action=GETALL");
                    break;
                case "EDIT":
                    Integer idDetail = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("book", bookService.finById(idDetail));
                    request.getRequestDispatcher("/views/edit-book.jsp").forward(request, response);
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
                    Book updateBS = new Book(
                            Integer.parseInt(request.getParameter("id")),
                            new Category(Integer.parseInt(request.getParameter("categoryId"))),
                            request.getParameter("name"),
                            Double.parseDouble(request.getParameter("price")),
                            Integer.parseInt(request.getParameter("stock")),
                            Integer.parseInt(request.getParameter("totalPages")),
                            Integer.parseInt(request.getParameter("yearCreated")),
                            request.getParameter("author"),
                            Boolean.parseBoolean(request.getParameter("status"))
                    );
                    bookService.save(updateBS);
                    response.sendRedirect("/books?action=GETALL");
                    break;
                case "ADD":
                    Book addbook = new Book(
                            0,
                            new Category(Integer.parseInt(request.getParameter("categoryId"))),
                            request.getParameter("name"),
                            Double.parseDouble(request.getParameter("price")),
                            Integer.parseInt(request.getParameter("stock")),
                            Integer.parseInt(request.getParameter("totalPages")),
                            Integer.parseInt(request.getParameter("yearCreated")),
                            request.getParameter("author"),
                            Boolean.parseBoolean(request.getParameter("status"))
                    );
                    bookService.save(addbook);
                    response.sendRedirect("/books?action=GETALL");

            }
        }
    }
}