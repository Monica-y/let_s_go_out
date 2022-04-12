package controller.sight;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "SightsRecommendServlet",
        urlPatterns = {"/sights/recommend"}
)
public class RecommendServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("/sights/recommend的请求不应该使用get方法！");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("user_id"));
        String houseName = request.getParameter("name");
        String inf = request.getParameter("inf");
        String address = request.getParameter("address");
        try {
            //获得文件列表
            //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
            String savePath = this.getServletContext().getRealPath("/WEB-INF/static/img/sights");
            DiskFileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("utf-8");
            if(!ServletFileUpload.isMultipartContent(request)){
                System.err.println("不是表单类型的数据！");
                return;
            }
            List<FileItem> fileItemList=upload.parseRequest(request);
            int state=userService.recommendSight(userID,fileItemList,houseName,inf,address,savePath);
            request.setAttribute("state",state);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
