package com.assigment.controller;

import com.assigment.connectSQL.ConnectMysql_19161232;
import com.assigment.dao.BookDAO_19161232;
import com.assigment.model.Book_19161232;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/books")
public class BookServlet_19161232 extends HttpServlet {
    BookDAO_19161232 bookDAO = new BookDAO_19161232(ConnectMysql_19161232.getConnection());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", bookDAO.getAllBooks());
        RequestDispatcher dispatcher = req.getRequestDispatcher("books.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        int isbn = Integer.parseInt(request.getParameter("isbn"));
        String title = request.getParameter("title");
        String publisher = request.getParameter("publisher");
        String priceStr = request.getParameter("price");
        String description = request.getParameter("description");
        String publishDateStr = request.getParameter("publishDate");
        String coverImage = request.getParameter("coverImage");
        String quantityStr = request.getParameter("quantity");

        // Xử lý dữ liệu đầu vào và chuyển đổi kiểu dữ liệu
        BigDecimal price = new BigDecimal(priceStr);
        int quantity = Integer.parseInt(quantityStr);
        Date publishDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            publishDate = dateFormat.parse(publishDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Book_19161232 book = new Book_19161232(isbn, title,publisher,price,description,publishDate,coverImage,quantity);
        bookDAO.addBook(book);
        resp.sendRedirect("/books");
    }
}
