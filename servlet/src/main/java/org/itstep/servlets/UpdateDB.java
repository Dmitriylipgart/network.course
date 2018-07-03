package org.itstep.servlets;


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


@MultipartConfig(location = "E:\\Downloads\\java ee\\network\\servlet\\src\\main\\Temp")
@WebServlet(value = "/update")
public class UpdateDB extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String str = req.getLocalName();
        String id = req.getParameter("id");
        String description = req.getParameter("description");
        Part filePart = req.getPart("file");
        InputStream is = filePart.getInputStream();
//       String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//
//        File file = new File(req.getSession().getServletContext().getRealPath("/") + "/" + fileName);
        FileRecord fileRecord = new FileRecord(id, description, is);
        fileRecord.update();
        getServletContext().getRequestDispatcher("/jsp/example.jsp").forward(req,resp);
    }
}
