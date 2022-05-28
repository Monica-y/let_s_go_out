package controller.user;

import javaBean.*;
import org.json.JSONObject;
import service.*;
import service.impl.*;
import state.State;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DetailinfServlet",
        urlPatterns = {"/usr/inf"}
)
public class DetailinfServlet extends HttpServlet {
    private HouseService houseService = new HouseServiceImpl();
    private HouseCommentService houseCommentService =
            new HouseCommentServiceImpl();
    private SightService sightService = new SightServiceImpl();
    private SightCommentService sightCommentService =
            new SightCommentServiceImpl();
    private UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        House house = null;
        List<HComment> hCommentList = null;
        Sight sight = null;
        List<SiComment> siCommentList = null;
        String path = null;
        //为了返回json格式的数据做准备
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();

        try {
            switch (type) {
                case "sights":
                    sight = sightService.getDetailInf(id);
                    siCommentList = sightCommentService.getInfByID(id);
                    for (SiComment T : siCommentList) {
                        User user = userService.getUserByID(T.getUserID());
                        T.setUserName(user.getName());
                    }
                    jsonObject.put("sights", sight);
                    jsonObject.put("comment", siCommentList);

                    System.out.println(sight);
                    System.out.println(siCommentList);
                    path = "/sightsDetail.html";
                    break;
                case "hotel":
                    house = houseService.getDetailInf(id);
                    hCommentList = houseCommentService.getInfByHouseID(id);
                    for (HComment T : hCommentList) {
                        User user = userService.getUserByID(T.getUserID());
                        T.setUserName(user.getName());
                    }
                    jsonObject.put("hotel", house);
                    jsonObject.put("comment", hCommentList);
                    System.out.println(house);
                    System.out.println(hCommentList);
                    path = "hotelDetail.html";
                    break;
                default:
                    break;
            }

        }
        catch (Exception e) {
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
        System.err.println("/usr/inf的请求不应该使用post方法！");
        doGet(request, response);
    }
}
