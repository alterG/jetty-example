import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Created by alterG on 14.07.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
//        Frontend fronted = new Frontend();
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
//        context.addServlet(new ServletHolder(frontend), "/authform");
        server.start();
        server.join();
    }
}
