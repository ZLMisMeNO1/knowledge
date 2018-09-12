import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

@Slf4j
public class StartServer {

    public static void main(String[] args) {
        // 服务器的监听端口
        Server server = new Server(9999);
        // 关联一个已经存在的上下文
        WebAppContext context = new WebAppContext();
        // 设置描述符位置
        context.setDescriptor("./id-generator/src/main/webapp/WEB-INF/web.xml");
        // 设置Web内容上下文路径
        context.setResourceBase("./id-generator/src/main/webapp");
        // 设置上下文路径
        context.setContextPath("/id-generator");
        context.setParentLoaderPriority(true);
        server.setHandler(context);


        try {
            server.start();
            log.info("server start");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("server is  start");
    }
}
