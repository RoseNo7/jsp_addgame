package com.sox.jsp.addgame.Servlet;

import com.sox.jsp.addgame.DAO.UserDAO;
import com.sox.jsp.addgame.DTO.UserDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignupServlet", value = "/SignupServlet")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/signup_form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        response.setCharacterEncoding("UTF-8");

        UserDAO userDAO = UserDAO.getInstance();

        UserDTO userDTO = new UserDTO();

        String id = request.getParameter("user_id");

        /* 아이디 중복 확인 */
        if (userDAO.selectUser(id) != null) {
            request.getRequestDispatcher("/signup_form.jsp").forward(request, response);
        } else {
            userDTO.setId(request.getParameter("user_id"));
            userDTO.setPassword(request.getParameter("user_pw"));
            userDTO.setName(request.getParameter("user_name"));
            userDTO.setEmail(request.getParameter("user_email"));

            userDAO.insertUser(userDTO);

            response.sendRedirect("index.jsp");
        }
    }
}
