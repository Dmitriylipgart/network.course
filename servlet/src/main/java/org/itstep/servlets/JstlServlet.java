package org.itstep.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Year;


@WebServlet(value = "/jstl")
public class JstlServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            processServlet(req, resp);

    }


    protected void processServlet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

        req.setAttribute("myVar", "Tratata");

        getServletContext().getRequestDispatcher("/jsp/jstlTest.jsp").forward(req,resp);

    }
}
