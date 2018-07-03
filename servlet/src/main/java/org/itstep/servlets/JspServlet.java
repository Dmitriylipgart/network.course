package org.itstep.servlets;

import org.itstep.servlets.dto.TestDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/jsp")
public class JspServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyMap = req.getParameter("keyMap");
        String valueMap = req.getParameter("valueMap");
        String valueList = req.getParameter("valueList");

        TestDTO testDTO = new TestDTO();
        testDTO.setKeyMap(keyMap);
        testDTO.setValueMap(valueMap);
        testDTO.setValueList(valueList);

        req.setAttribute("test", testDTO);

        req.setAttribute("keyMap1", keyMap);

        getServletContext().getRequestDispatcher("/html/example.jsp").forward(req,resp);

    }
}
