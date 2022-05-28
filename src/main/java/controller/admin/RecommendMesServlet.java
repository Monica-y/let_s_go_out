package controller.admin;

import javaBean.House;
import javaBean.Sight;
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
        name = "RecommendMesServlet",
        urlPatterns = {"/admin/inf"}
)
public class RecommendMesServlet extends HttpServlet {
    private AdminService adminService=new AdminServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int adminId = Integer.parseInt(request.getParameter("admin_id"));
        String adminName = request.getParameter("admin_name");
        String type = request.getParameter("type");
        //为了返回json格式的数据做准备
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        List<Sight> sightList=null;
        List<House> houseList=null;
        try {
            switch (type){
                case "sights":
                    sightList=adminService.getAllSightRecommend(adminId,adminName);
                    jsonObject.put("sights_list",sightList);
                    break;
                case "hotel":
                    houseList=adminService.getAllHouseRecommend(adminId,adminName);
                    jsonObject.put("hotel_list",houseList);
                    break;
                default:
                    break;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        jsonObject.put("state", State.SUCCESS);
        PrintWriter writer = response.getWriter();
        writer.print(jsonObject);
        writer.flush();
        writer.close();
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("/admin/userInf的请求不应该使用post方法！");
        doGet(request,response);
    }
}
