package controller.admin;

import javaBean.User;
import service.AdminService;
import service.impl.AdminServiceImpl;
import state.State;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet",
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
