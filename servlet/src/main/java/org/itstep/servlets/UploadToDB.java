package org.itstep.servlets;

import entity.FileRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.sql.*;


@MultipartConfig(location = "D:\\Html\\network.course\\servlet\\src\\main\\Temp")
@WebServlet(value = "/uploadFile")
public class UploadToDB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("html/fail.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        String description = req.getParameter("description");

        Part filePart = req.getPart("file");

        InputStream is = filePart.getInputStream();

//        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//
//        File file = new File(req.getSession().getServletContext().getRealPath("/") + "/" + fileName);

        FileRecord fileRecord = new FileRecord(description, is);

        fileRecord.createRecord();

        getServletContext().getRequestDispatcher("/jsp/example.jsp").forward(req, resp);
    }


}
