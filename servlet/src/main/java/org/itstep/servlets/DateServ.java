package org.itstep.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DateServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String date = req.getParameter("date");

        try (PrintWriter writer = resp.getWriter()){
            writer.print("fjsdljflsdkjflskd");
            writer.print(date);
        } catch (Exception e) {


        }

    }
}
