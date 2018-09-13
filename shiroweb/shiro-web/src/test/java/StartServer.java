import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

@Slf4j
public class StartServer {

    public static void main(String[] args) {
        // 服务器的监听端口
        Server server = new Server(8002);
        // 关联一个已经存在的上下文
        WebAppContext context = new WebAppContext();
        // 设置描述符位置
        context.setDescriptor("./shiroweb/shiro-web/src/main/webapp/WEB-INF/web.xml");
        // 设置Web内容上下文路径
        context.setResourceBase("./shiroweb/shiro-web/src/main/webapp");
        // 设置上下文路径
        context.setContextPath("/shiroweb");
        context.setParentLoaderPriority(true);
        server.setHandler(context);


        try {
            server.start();
            log.info("地址 -> http://localhost:8002/shiroweb");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
