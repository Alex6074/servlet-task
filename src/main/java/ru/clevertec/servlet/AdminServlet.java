package ru.clevertec.servlet;

import ru.clevertec.entity.User;
import ru.clevertec.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "admin-servlet", value = "/admin")
public class AdminServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(0, req.getParameter("login"), req.getParameter("password"));
        userService.save(user);
        resp.sendRedirect("user/admin.jsp");
    }
}
