import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Player extends JPanel
{
	private static int playerW=100;
	private static int playerH=100;
	private static int playerx=Game.WIDTH/2-playerW/2;
	private static int playery=Game.HEIGHT-playerH;
	private static int movex=0;
	private static int movey=0;
	public static ArrayList<Ball> balls = new ArrayList<Ball>();
	private Image player;
	private Image computer;
	private Image background;
	
	public static void addBall(Ball ball)
	{
		balls.add(ball);
	}
	
	public static int player_up()
	{
		return movey=-5;
	}
	public static int player_down()
	{
		return movey=5;
	}
	public static int player_left()
	{
		return movex=-5;
	}
	public static int player_right()
	{
		return movex=5;
	}
	public static int releaseX()
	{
		return movex=0;
	}
	public static int releaseY()
	{
		return movey=0;
	}
	public void move()
	{
		playerx+=movex;
		playery+=movey;
		background=new ImageIcon("img/background.png").getImage();
		player=new ImageIcon("img/player.png").getImage();
		if(playerx+playerW>Game.WIDTH)
			movex=-1;
		else if(playerx<=0)
			movex=1;
		if(playery+playerH>Game.HEIGHT)
			movey=-1;
		else if(playery<=0)
			movey=1;
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(background,0,0,null);
		g.drawImage(player,playerx,playery,null);
	}
}
