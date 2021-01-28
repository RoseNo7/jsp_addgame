package com.sox.jsp.addgame.Servlet;

import com.sox.jsp.addgame.DAO.UserDAO;
import com.sox.jsp.addgame.DTO.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("user_id");
        String userPW = request.getParameter("user_pw");

        UserDAO userDAO = UserDAO.getInstance();
        UserDTO userDTO = userDAO.selectUser(userID);

        if (userID.equals(userDTO.getId()) && userPW.equals(userDTO.getPassword())) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", userID);

            request.getRequestDispatcher("/main.jsp").forward(request, response);

        } else {
            response.sendRedirect("index.jsp");
        }
    }
}
