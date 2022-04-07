package controller.user;

import javaBean.User;
import service.UserService;
import service.impl.UserServiceImpl;
import state.State;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "UserLoginServlet",
        value = "/LoginServlet",
        urlPatterns = {"/user/login"}
)
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("/user/login的请求不应该使用get方法！");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user_name");
        String password = request.getParameter("password");
        int state = 0;
        try {
            state = userService.userLogin(userName, password);
            if (state == State.SUCCESS) {
                User user = userService.getUserByName(userName);
                HttpSession session = request.getSession();
                session.setAttribute("user_id", user.getUserID());
                session.setAttribute("user_name", userName);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("state",state);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
