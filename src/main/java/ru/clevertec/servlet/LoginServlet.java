package ru.clevertec.servlet;

import ru.clevertec.entity.User;
import ru.clevertec.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login-servlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") != null) {
            resp.sendRedirect("/user/hello.jsp");
        } else {
            resp.sendRedirect("/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.findUserByLogin(req.getParameter("login"));
        if (user != null && user.getPassword().equals(req.getParameter("password"))
                && user.getLogin().equals("admin")) {
            req.getSession().setAttribute("user", req.getParameter("login"));
            resp.sendRedirect("/user/admin.jsp");
        } else if (user != null && user.getPassword().equals(req.getParameter("password"))) {
            req.getSession().setAttribute("user", req.getParameter("login"));
            resp.sendRedirect("/user/hello.jsp");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}