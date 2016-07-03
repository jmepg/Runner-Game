package Server;


import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;


import GUI.Game;



public class Server {

    private static HttpServer server;

     public Server(Game game) throws Exception {
		server = HttpServer.create(new InetSocketAddress(8000), 0);
		server.createContext("/api", new Handler(game));
		server.setExecutor(null);
		
		
		
	}

    public static void start()
    {
        server.start();
    }


}
