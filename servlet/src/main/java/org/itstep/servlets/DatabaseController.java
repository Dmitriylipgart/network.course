package org.itstep.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;


public abstract class DatabaseController extends HttpServlet {
    String str;
    String id;
    String description;
    Part filePart;
    String fileName;
    InputStream is;


    void loadFile(HttpServletRequest req) throws ServletException, IOException{

        str = req.getLocalName();
        id = req.getParameter("id");
        description = req.getParameter("description");
        filePart = req.getPart("file");
        is = filePart.getInputStream();
        fileName = getSubmittedFileName(filePart);
    }

    //        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//
//        File file = new File(req.getSession().getServletContext().getRealPath("/") + "/" + fileName); // Для Tomcat 8

     String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
}
