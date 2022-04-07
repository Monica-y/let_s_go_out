package controller.admin;

import javaBean.User;
import service.AdminService;
import service.UserService;
import service.impl.AdminServiceImpl;
import service.impl.UserServiceImpl;
import state.State;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet",
        value = "/LoginServlet",
        urlPatterns = {"/admin/login"}
)
public class LoginServlet extends HttpServlet {
    private AdminService adminService=new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("/admin/login的请求不应该使用get方法！");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("admin_name");
        String password = request.getParameter("password");
        int state = 0;
        try {
            state = adminService.adminLogin(adminName,password);
            if (state == State.SUCCESS) {
                User user = adminService.getAdminByName(adminName);
                HttpSession session = request.getSession();
                session.setAttribute("admin_id", user.getUserID());
                session.setAttribute("admin_name", adminName);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("state",state);
        request.getRequestDispatcher("/adminIndex.jsp").forward(request,response);
    }

}
