import java.io.File;

/**
 * @program: exercise2_lets_go_out
 * @author: qin haojun
 * @create: 2022-04-11 22:18
 */
public class Test {
    public static void main(String[] args) {
        String path="C:\\Users\\86186\\Desktop\\database\\static\\img\\hotel";
        File file=new File(path);
        file.mkdir();
    }

}
