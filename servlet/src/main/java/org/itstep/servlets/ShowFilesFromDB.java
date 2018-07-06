package org.itstep.servlets;

import entity.FileRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@MultipartConfig()
@WebServlet(value = "/jsp/showfilelist")

public class ShowFilesFromDB extends DatabaseController{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showAllRecords(req);
        getServletContext().getRequestDispatcher("/jsp/main.jsp").forward(req,resp);
    }
}
