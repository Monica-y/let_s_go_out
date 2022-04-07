package controller.admin;

import service.AdminService;
import service.impl.AdminServiceImpl;
import state.State;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "UserDeleteServlet",
        value = "/UserDeleteServlet",
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
        request.setAttribute("state",state);
        request.getRequestDispatcher("/adminIndex.jsp").forward(request,response);
    }
}

