package controller.user;

import service.HouseCommentService;
import service.SightCommentService;
import service.impl.HouseCommentServiceImpl;
import service.impl.SightCommentServiceImpl;
import state.State;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "PublishCommentServlet",
        value = "/PublishCommentServlet",
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
        String path="/"+type+"Detail.jsp";
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
        request.setAttribute("state",state);
        request.getRequestDispatcher(path).forward(request,response);
    }
}
