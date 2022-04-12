package controller.user;

import javaBean.House;
import javaBean.Sight;
import org.json.JSONObject;
import service.HouseService;
import service.SightService;
import service.impl.HouseServiceImpl;
import service.impl.SightServiceImpl;
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
        name = "BriefinfServlet",
        urlPatterns = {"/usr/brief-inf"}
)
public class BriefinfServlet extends HttpServlet {
    private SightService sightService=new SightServiceImpl();
    private HouseService houseService=new HouseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Sight> sightList=null;
        List<House> houseList=null;
        //为了返回json格式的数据做准备
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        String type = request.getParameter("type");
        try {
            switch (type){
                case "hotel":
                    houseList=houseService.getAllBrief();
                    jsonObject.put("hotel_list",houseList);
                    System.out.println(houseList);
                    break;
                case "sights":
                    sightList=sightService.getAllBrief();
                    jsonObject.put("sights_list",sightList);
                    System.out.println(sightList);
                    break;
                default:
                    break;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        jsonObject.put("state",State.SUCCESS);
        PrintWriter writer = response.getWriter();
        writer.print(jsonObject);
        writer.flush();
        writer.close();
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("/usr/brief-inf的请求不应该使用post方法！");
        doGet(request, response);
    }
}
