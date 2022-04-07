package controller.user;

import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "RegisterServlet",
        value = "/RegisterServlet",
        urlPatterns = {"/user/register"}
)
public class RegisterServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("/user/register的请求不应该使用get方法！");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user_name");
        String password = request.getParameter("password");
        int state = 0;
        try {
            state = userService.registerUser(userName, password);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("state",state);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
