package org.itstep.servlets;


import entity.DatabaseService;
import entity.FileRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;


@MultipartConfig()
@WebServlet(value = "/jsp/update")
public class UpdateDB extends DatabaseController{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        loadFile(req);
        FileRecord fileRecord = new FileRecord(id, description, is);
        fileRecord.update();
        getServletContext().getRequestDispatcher("/jsp/example.jsp").forward(req,resp);
    }
}
