package org.itstep.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entity.Mysqlcon;

@MultipartConfig(location = "E:\\Downloads\\java ee\\network\\servlet\\src\\main\\Temp")
@WebServlet(value = "/file3")
public class UploadToMySQL extends HttpServlet {

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

        try {
            writeToDB(is, description);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    private void writeToDB(InputStream is, String description) throws SQLException {

        Connection connection = new Mysqlcon().getConnection();

        String sql = "Insert into files (file, description) " //
                + " values (?,?) ";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setBinaryStream(1,  is);
        statement.setString(2, description);
        statement.executeUpdate();

    }



}
