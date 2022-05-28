package controller.user;

import org.json.JSONObject;
import service.HouseCommentService;
import service.SightCommentService;
import service.impl.HouseCommentServiceImpl;
import service.impl.SightCommentServiceImpl;
import state.State;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "PublishCommentServlet",
        urlPatterns = {"/usr/comment"}
)
public class PublishCommentServlet extends HttpServlet {
    private SightCommentService sightCommentService=new SightCommentServiceImpl();
    private HouseCommentService houseCommentService=new HouseCommentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("/usr/comment的请求不应该使用get方法！");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        int id= Integer.parseInt(request.getParameter("id"));
        String comment = request.getParameter("comment");
        String type = request.getParameter("type");
        int state=State.UNKNOW_ERROR;
        try {
            switch (type) {
                case "hotel":
                    state = houseCommentService.publishComment(userId, id, comment);
                    break;
                case "sights":
                    state=sightCommentService.publishComment(userId,id,comment);
                    break;
                default:
                    System.err.println("type不在取值中！");
                    break;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //为了返回json格式的数据做准备
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        PrintWriter writer = response.getWriter();
        jsonObject.put("state",state);
        writer.print(jsonObject);
        writer.flush();
        writer.close();
        return;
    }
}
