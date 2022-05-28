import java.io.File;
import java.util.Date;

import javaBean.Sight;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import service.impl.SightServiceImpl;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-04-11 22:18
 */
public class WEBTest {
    @Test
    public void test() {
        String filePath="C:\\Users\\86186\\apache-tomcat-9.0.31\\webapps\\letsgoout\\img\\hotel";
        filePath=filePath.substring(filePath.lastIndexOf("img")-1);
        File file=new File(filePath);
        file.mkdir();
    }

    @Test
    public void json() throws Exception {
        Sight person =   new SightServiceImpl().getDetailInf(1);
        person.setSightName( "Person Name" );
        person.setStatus( 333 );


        JSONObject jsonObj = new JSONObject();
        jsonObj.put("sight",person);

        System.out.println( jsonObj );
    }



}
