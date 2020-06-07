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
	public static int base = 1;
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
	public static void popBall()
	{
		while(balls.size() != base)
			balls.remove(balls.size() - 1);
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
		
	}
}

