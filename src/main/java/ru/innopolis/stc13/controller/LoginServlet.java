package ru.innopolis.stc13.controller;

import ru.innopolis.stc13.service.UserService;
import ru.innopolis.stc13.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (userService.checkAuth(login, password)) {
            int role = userService.getRole(login);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);
            resp.sendRedirect("/inner/dashboard");
        } else {
            resp.sendRedirect("/login?err_code=wrong_login");
        }
    }
}
