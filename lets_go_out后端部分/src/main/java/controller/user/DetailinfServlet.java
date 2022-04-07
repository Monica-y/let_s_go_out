package controller.user;

import javaBean.*;
import service.*;
import service.impl.*;
import state.State;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailinfServlet",
        value = "/DetailServlet",
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
        House house=null;
        List<HComment> hCommentList =null;
        Sight sight=null;
        List<SiComment> siCommentList=null;
        String path=null;
        try{
            switch (type){
                case "sights":
                    sight=sightService.getDetailInf(id);
                    siCommentList=sightCommentService.getInfByID(id);
                    for (SiComment T : siCommentList) {
                        User user = userService.getUserByID(T.getUserID());
                        T.setUserName(user.getName());
                    }
                    request.setAttribute("sights",sight);
                    request.setAttribute("comment",siCommentList);
                    path="/sightsDetail.jsp";
                    break;
                case "hotel":
                    house=houseService.getDetailInf(id);
                    hCommentList=houseCommentService.getInfByHouseID(id);
                    for (HComment T : hCommentList) {
                        User user=userService.getUserByID(T.getUserID());
                        T.setUserName(user.getName());
                    }
                    request.setAttribute("hotel",house);
                    request.setAttribute("comment",hCommentList);
                    path="hotelDetail.jsp";
                    break;
                default:
                    break;
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        request.setAttribute("state", State.SUCCESS);
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("/usr/inf的请求不应该使用post方法！");
        doGet(request, response);
    }
}
