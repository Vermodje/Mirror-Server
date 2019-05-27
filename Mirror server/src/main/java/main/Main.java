package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlet.MirrorServlet;

public class Main {
    public static void main(String[] args) throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new MirrorServlet()), "/mirror");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        System.out.println("Server started!");
        server.join();
    }
}
