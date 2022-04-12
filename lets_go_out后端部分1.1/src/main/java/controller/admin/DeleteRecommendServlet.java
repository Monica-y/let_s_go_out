package controller.admin;

import service.AdminService;
import service.impl.AdminServiceImpl;
import state.State;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "DeleteRecommendServlet",
        urlPatterns = {"/admin/delete"}
)
public class DeleteRecommendServlet extends HttpServlet {
    private AdminService adminService=new AdminServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("/admin/delete的请求不应该使用get方法！");
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("admin_name");
        int adminID = Integer.parseInt(request.getParameter("admin_id"));
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        int state= State.UNKNOW_ERROR;
        try {
            switch (type){
                case "hotel":
                    state=adminService.deleteRecommendHouseByHouseID(adminID,adminName,id);
                    break;
                case "sights":
                    state=adminService.deleteRecommendSightBySightID(adminID,adminName,id);
                    break;
                default:
                    System.err.println("/admin/delete中没有找到对应type！");
                    break;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        request.setAttribute("state",state);
        System.out.println(state);
        request.getRequestDispatcher("/adminIndex.jsp").forward(request,response);

    }
}
