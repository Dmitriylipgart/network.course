package org.itstep.servlets;

import org.itstep.servlets.dto.TestDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@WebServlet(value = "/jstl")
public class JstlServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            processServlet(req, resp);

    }


    protected void processServlet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

        List<TestDTO> list = new ArrayList<>();
        TestDTO testDTO = new TestDTO();
        testDTO.setKeyMap("4").setValueList("4").setValueMap("jfldkjf");
        list.add(testDTO);
        list.add(testDTO);
        list.add(testDTO);

        req.setAttribute("myVar", list);

        getServletContext().getRequestDispatcher("/jsp/jstlTest.jsp").forward(req,resp);

    }
}
