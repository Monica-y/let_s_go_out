package controller.sight;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "SightsRecommendServlet",
        urlPatterns = {"/sights/recommend"}
)
@MultipartConfig //设置了这个不是文件的参数才能取出
public class RecommendServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("/sights/recommend的请求不应该使用get方法！");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("user_id"));
        String houseName = request.getParameter("name");
        houseName = new String(houseName.getBytes(StandardCharsets.ISO_8859_1), "utf-8");
        String inf = request.getParameter("inf");
        inf = new String(inf.getBytes(StandardCharsets.ISO_8859_1), "utf-8");
        String address = request.getParameter("address");
        address = new String(address.getBytes(StandardCharsets.ISO_8859_1), "utf-8");
        //为了返回json格式的数据做准备
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        try {
            //获得文件保存路径
            String savePath = this.getServletContext().getRealPath("/img/sights");
            if (!ServletFileUpload.isMultipartContent(request)) {
                System.err.println("不是表单类型的数据！");
                return;
            }
            List<Part> fileItemList = new ArrayList<>();
            fileItemList.add(request.getPart("img"));
            int state = userService.recommendSight(userID, fileItemList, houseName, inf, address, savePath);
            jsonObject.put("state", state);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        PrintWriter writer = response.getWriter();
        writer.print(jsonObject);
        writer.flush();
        writer.close();
        return;
    }

}
