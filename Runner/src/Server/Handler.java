package Server;


import GUI.*;
import LOGIC.Avatar;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class Handler implements HttpHandler{
	Game game;
    public Handler(Game game){
    	this.game = game;
    }


    @Override
    public void handle(HttpExchange t) throws IOException {

    	String response = "";
    	String path = t.getRequestURI().getPath();
    	String newPath;
    	int playerNum=0;
    	
    	if(path.endsWith("left")){
    			newPath = path.substring(0,path.length()-5);
    			newPath = newPath.substring(newPath.length()-1);
    			playerNum=Integer.parseInt(newPath);
    			moveLeft(playerNum-1);
    			}
    	else if(path.endsWith("right")){
    		newPath = path.substring(0,path.length()-6);
    		newPath = newPath.substring(newPath.length()-1);
    		playerNum=Integer.parseInt(newPath);
    		moveRight(playerNum-1);}
    	else if(path.endsWith("stop")){
    		newPath = path.substring(0,path.length()-5);
    		newPath = newPath.substring(newPath.length()-1);
    		playerNum=Integer.parseInt(newPath);
    		moveStop(playerNum-1);}
    	else if(path.endsWith("disconnect")){
    		
    		newPath = path.substring(0,path.length()-11);
    		newPath = newPath.substring(newPath.length()-1);
    		playerNum=Integer.parseInt(newPath);
    		response = disconnect(playerNum);
    	}
    	else if(path.endsWith("connect")){
    		response = connect();
    		}
    	
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    
    }



	private void moveRight(int index) {
		game.getListPlayers().get(index).setVelX(2);;
	}
	
	private void moveStop(int index) {
		game.getListPlayers().get(index).setVelX(0);;
	}


	private void moveLeft(int index) {
		game.getListPlayers().get(index).setVelX(-2);;
	}
	
	public String connect(){
		for(int j=0;j<game.getListPlayers().size();j++){
			if(game.getListPlayers().get(j)==null){
				game.startPlayer(j);
				return Integer.toString(j+1);
				}
		}
		return "max";
		
	}

	private String disconnect(int id) {
		Avatar avatar = null;
		game.getListPlayers().set(id-1, avatar);		
		return "ok";
	}
    
    
  
 

}
