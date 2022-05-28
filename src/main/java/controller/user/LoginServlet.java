package controller.user;

import javaBean.User;
import org.json.JSONObject;
import service.UserService;
import service.impl.UserServiceImpl;
import state.State;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "UserLoginServlet",
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //用户登录
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
        //为了返回json格式的数据做准备
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state",state);
        PrintWriter writer = response.getWriter();
        writer.print(jsonObject);
        writer.flush();
        writer.close();
        return;
    }
}
