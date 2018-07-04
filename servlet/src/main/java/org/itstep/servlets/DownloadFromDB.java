package org.itstep.servlets;

import entity.FileRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@MultipartConfig(location = "D:\\Html\\network.course\\servlet\\src\\main\\Temp")
@WebServlet(value = "/downloadFile")

public class DownloadFromDB extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String downloadType = req.getParameter("downloadType");

        if (downloadType.equals("all")){

            List<FileRecord> records = new FileRecord().readAll();

            for (FileRecord record: records){
            record.getFile();
            }

        } else {

            FileRecord fileRecord = new FileRecord(id).read();
        }



        getServletContext().getRequestDispatcher("/jsp/example.jsp").forward(req,resp);
    }


}
