package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestServlet;

/**
 * Created by alterG on 14.07.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AllRequestServlet allRequestServlet = new AllRequestServlet();
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);
        context.addServlet(new ServletHolder(allRequestServlet), "/*");
        server.start();
        server.join();
    }
}
