package com.sox.jsp.addgame.Servlet;

import com.sox.jsp.addgame.DAO.UserDAO;
import com.sox.jsp.addgame.DTO.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckIdServlet", value = "/CheckId.do")
public class CheckIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("id");

        UserDAO userDAO = UserDAO.getInstance();
        UserDTO userDTO = userDAO.selectUser(ID);

        PrintWriter out = response.getWriter();

        if (userDTO.getId() != null) {
            out.print("exist");
        } else {
            out.print("not exist");
        }
    }
}
