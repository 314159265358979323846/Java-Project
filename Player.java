import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;



public class Player extends JPanel
{
	private static int playerW=100;
	private static int playerH=100;
	private  int playerx=Game.WIDTH/2-playerW/2;
	private  int playery=Game.HEIGHT-playerH;
	private  int movex=0;
	private  int person;
	public static ArrayList<Ball> balls = new ArrayList<Ball>();
	private Image player;
	
	
	public Player(int person){
		this.person=person;
		switch (person) {
		case 1:
			playery=Game.HEIGHT-playerH;
			break;
		case 2:
			playery=0;
			break;
		default:
			break;
		}
		
	}
	public static void addBall(Ball ball)
	{
		balls.add(ball);
	}
	
	
	public  int player_left()
	{
		return movex=-5;
	}
	public  int player_right()
	{
		return movex=5;
	}
	public  int releaseX()
	{
		return movex=0;
	}
	
	public void move()
	{
		playerx+=movex;
		toBall();
		player=new ImageIcon("img/player.png").getImage();
		if(playerx+playerW>Game.WIDTH)
			playerx=Game.WIDTH-playerW;
		else if(playerx<=0)
			playerx=0;
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(player,playerx,playery,null);
	}
	public void toBall() {
		for (Ball ball : balls) {
			if(collision(ball)) {
					ball.setVel(5, -5);
					
			}
		}
		
	}
	public Boolean collision(Ball b) {
		Rectangle ballRectangle= new Rectangle(b.getX(),b.getY(),60,60);
		Rectangle playerRectangle= new Rectangle(this.playerx,this.playery,100,100);
		if (ballRectangle.getBounds().intersects(playerRectangle.getBounds())||
				playerRectangle.getBounds().intersects(ballRectangle.getBounds())
				) {
			return true;
		}else {
			return false;
		}
	}
}
