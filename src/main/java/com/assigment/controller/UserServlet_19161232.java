package com.assigment.controller;

import com.assigment.connectSQL.ConnectMysql_19161232;
import com.assigment.dao.BookDAO_19161232;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "")
public class UserServlet_19161232 extends HttpServlet {
    BookDAO_19161232 bookDAO = new BookDAO_19161232(ConnectMysql_19161232.getConnection());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", bookDAO.getAllBooks());
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }

}
