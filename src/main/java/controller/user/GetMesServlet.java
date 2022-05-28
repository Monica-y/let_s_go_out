package controller.user;

import org.json.JSONObject;
import state.State;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetMesServlet",
        urlPatterns = {"/usr/getMes"})
public class GetMesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object user_id = session.getAttribute("user_id");
        Object user_name = session.getAttribute("user_name");
        //为了返回json格式的数据做准备
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        if(null==user_name){
            jsonObject.put("state",State.NO_LOGIN);
        }
        else {
            jsonObject.put("user_id", user_id);
            jsonObject.put("user_name", user_name);
            jsonObject.put("state",State.SUCCESS);
        }
        PrintWriter writer = response.getWriter();
        writer.print(jsonObject);
        writer.flush();
        writer.close();
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
