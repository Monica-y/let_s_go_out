package controller.admin;

import javaBean.User;
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
import java.util.List;

@WebServlet(
        name = "UserMesServlet",
        urlPatterns = {"/admin/userInf"}
)
public class UserMesServlet extends HttpServlet {
    private AdminService adminService=new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int adminId = Integer.parseInt(request.getParameter("admin_id"));
        String adminName = request.getParameter("admin_name");
        List<User> userList= null;
        try {
            userList = adminService.getAllInf(adminId,adminName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //为了返回json格式的数据做准备
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("state", State.SUCCESS);
        jsonObject.put("user_list",userList);
        PrintWriter writer = response.getWriter();
        writer.print(jsonObject);
        writer.flush();
        writer.close();
        // System.out.println(userList);
        return;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("/admin/userInf的请求不应该使用post方法！");
        doGet(request,response);
    }
}
