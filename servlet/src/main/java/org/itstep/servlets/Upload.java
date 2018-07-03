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


@MultipartConfig(location = "E:\\Downloads\\java ee\\network\\servlet\\src\\main\\Temp")
@WebServlet(value = "/file")
public class Upload extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        String description = req.getParameter("description");

//        resp.sendRedirect("html/File.html");

        Part filePart = req.getPart("file");

        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        File file = new File(req.getSession().getServletContext().getRealPath("/") + "/" + fileName);

        String line;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(filePart.getInputStream()));

        PrintWriter printWriter = resp.getWriter();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        while((line = bufferedReader.readLine()) != null ) {
            bufferedWriter.write(line);
            bufferedWriter.flush();
        }

        printWriter.write("Файл " + file.getName() + " сохранен в " + file.getAbsolutePath() + " Описание: " + description);


    }
}
