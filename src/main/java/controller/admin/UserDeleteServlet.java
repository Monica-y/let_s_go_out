package controller.admin;

import org.json.JSONObject;
import service.AdminService;
import service.impl.AdminServiceImpl;
import state.State;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "UserDeleteServlet",
        urlPatterns = {"/admin/deleteUser"}
)
public class UserDeleteServlet extends HttpServlet {
    private AdminService adminService=new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("/admin/deleteUser的请求不应该使用get方法！");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("admin_name");
        int adminID = Integer.parseInt(request.getParameter("admin_id"));
        int userId = Integer.parseInt(request.getParameter("user_id"));
        int state = State.UNKNOW_ERROR;
        try {
            state = adminService.deleteUserByUserID(adminID, adminName, userId);
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

