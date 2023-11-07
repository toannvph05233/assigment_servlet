package com.assigment.controller;


import com.assigment.connectSQL.ConnectMysql_19161232;
import com.assigment.dao.UserDAO_19161232;
import com.assigment.model.User_19161232;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet_19161232 extends HttpServlet {
    UserDAO_19161232 userDAO = new UserDAO_19161232(ConnectMysql_19161232.getConnection());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mess = req.getParameter("mess");
        if (mess != null){
            mess = "Sai tài khoản or mật khẩu";
            req.setAttribute("mess", mess);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User_19161232 user = userDAO.checklogin(email,password);
        if (user!= null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            if (user.isAdmin()){
                resp.sendRedirect("/books");
            }else {
                resp.sendRedirect("/");
            }
        } else {
            resp.sendRedirect("/login?mess=error");
        }
    }
}
