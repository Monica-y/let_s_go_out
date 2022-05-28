package controller.admin;

import org.json.JSONObject;
import state.State;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GetAdminMesServlet",
        urlPatterns = {"/admin/getMes"})
public class GetAdminMesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object admin_id = session.getAttribute("admin_id");
        Object admin_name = session.getAttribute("admin_name");
        //为了返回json格式的数据做准备
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        if(null==admin_name){
            jsonObject.put("state", State.NO_LOGIN);
        }
        else {
            jsonObject.put("admin_id", admin_id);
            jsonObject.put("admin_name", admin_name);
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
