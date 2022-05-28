package controller.user;

import org.json.JSONObject;
import service.UserService;
import service.impl.UserServiceImpl;
import state.State;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "RegisterServlet",
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
            state = userService.registerUser(userName, password);}
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
