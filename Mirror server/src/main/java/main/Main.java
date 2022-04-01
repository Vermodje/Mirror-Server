package main;

import com.sun.deploy.net.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import servlet.MirrorServlet;
import sun.net.www.http.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class Main {
    public static void main(String[] args) throws Exception {

//        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.addServlet(new ServletHolder(new MirrorServlet()), "/mirror");

//        Server server = new Server(8080);
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8090);
        server.setConnectors(new Connector[]{connector});
//        server.setHandler(context);
        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(MirrorServlet.class, "/mirror");
        server.start();
        System.out.println("Server started!");
        //server.join();
//        String url = "http://localhost:8080/mirror?key=value";
//        CloseableHttpClient client = HttpClientBuilder.create().build();
//        HttpGet request = new HttpGet(url);
//        CloseableHttpResponse response = client.execute(request);
//        System.out.println(response);
    }
}
