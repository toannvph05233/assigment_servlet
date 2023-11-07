package com.assigment.controller;


import com.assigment.connectSQL.ConnectMysql_19161232;
import com.assigment.dao.UserDAO_19161232;
import com.assigment.model.User_19161232;

import java.io.IOException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet_19161232 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO_19161232 userDAO = new UserDAO_19161232(ConnectMysql_19161232.getConnection());


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mess = request.getParameter("mess");
        if (mess.equals("rePass")){
            mess = "Nhập Lại Mật Khẩu Sai!";
            request.setAttribute("mess", mess);
        } else if (mess.equals("email")){
            mess = "email đã có ngươi sử dụng!";
            request.setAttribute("mess", mess);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String mess ="";
            String email = request.getParameter("email");
            String pass = request.getParameter("password");
            String repass = request.getParameter("rePass");
            String fullname = request.getParameter("fullname");
            String phone = request.getParameter("phone");
            if (!pass.equals(repass)) {
                response.sendRedirect("/register?mess=rePass");
            } else {
                User_19161232 user = userDAO.getUserByEmail(email);
                if (user != null) {
                    response.sendRedirect("/register?mess=email");
                } else {
                    User_19161232 newUser = new User_19161232(email, fullname, Integer.parseInt(phone),pass, new Date(), new Date(), false);
                    userDAO.addUser(newUser);
                    response.sendRedirect("/login");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
