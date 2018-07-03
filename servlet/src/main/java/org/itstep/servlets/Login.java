package org.itstep.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class Login extends HttpServlet {

    private static final String LOGIN = "Login";
    private static final String PASSWORD = "Password";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("name");
        String password = req.getParameter("password");

        if ((login.compareTo(LOGIN) !=0) || (password.compareTo(PASSWORD) !=0)){
            resp.sendRedirect("html/fail.html");
        } else {
            resp.sendRedirect("html/File.html");
        }


        try(PrintWriter printWriter = resp.getWriter()){
            printWriter.write(login + " " + password);
        }
    }


}
