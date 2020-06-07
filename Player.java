import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import sun.jvmstat.monitor.Units;
import sun.tools.jconsole.Plotter.Unit;



public class Player extends JPanel
{
	private static int playerW=150;
	private static int playerH=50;
	private  int playerx=Game.WIDTH/2-playerW/2;
	private  int playery=Game.HEIGHT-playerH;
	private  int movex=0;
	private  int person;
	public static ArrayList<Ball> balls = new ArrayList<Ball>();
	private Image player;
	public static int base = 1;
	
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
		//player=new ImageIcon("img/player.png").getImage();
		if(playerx+playerW>Game.WIDTH)
			playerx=Game.WIDTH-playerW;
		else if(playerx<=0)
			playerx=0;
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		//g.drawImage(player,playerx,playery,null);
		
		g.fillRect(playerx, playery, playerW, playerH);
	}
	public static void popBall()
	{
		while(balls.size() != base)
			balls.remove(balls.size() - 1);
	}
	public void toBall() {
		for (Ball b : balls) {
			if(collision(b)) {
			Random r=new Random();
		
				if((b.getX()+30<playerx)&&(b.getVx()>0))
					b.setVel(-b.getVx(), -b.getVy()+r.nextInt(6)-3);
				else if(b.getX()+30>playerx+playerW&&(b.getVx()<0))
					b.setVel(-b.getVx()+r.nextInt(6)-3, -b.getVy());
				else 	
			      b.setVel(b.getVx()+r.nextInt(6)-3, -b.getVy()+r.nextInt(6)-3);	
				if(Mode.mode.equals("special")) {
					switch (r.nextInt(3)) {
					case 0:
						//choose wave/circle/slow down......
						break;
					case 1:
						
						break;
					case 2:
	
						break;
					default:
						break;
					}
				}
	
					
			}
		}
		
	}
	
	public Boolean collision(Ball b) {
		Rectangle ballRectangle= new Rectangle(b.getX(),b.getY(),60,60);
		Rectangle playerRectangle= new Rectangle(playerx+movex,playery,playerW,playerH);
		if (ballRectangle.getBounds().intersects(playerRectangle.getBounds())||
				playerRectangle.getBounds().intersects(ballRectangle.getBounds())
				) {//Point2D.distance(b.getX()+30, b.getY()+30,playerx+50 ,playery+50)<80
			
				b.setPos(b.getX()-b.getVx(),b.getY()-b.getVy());
			
			if(b.getX() + 60 >= Game.WIDTH )
				b.setPos(Game.WIDTH-60, b.getY());
			if(b.getX() <= 0)
				b.setPos(0, b.getY());
			if(b.getY() + 60 >= Game.HEIGHT )
				b.setPos( b.getX(), Game.HEIGHT-60);
			if( b.getY() <= 0)
				b.setPos( b.getX(), 2);
			return true;
		}else {
			return false;
		}
	}
	
	public void computerMove(Ball b) {
		// TODO Auto-generated method stub
		int pred;
		if (b.getVy()< 0) {// ball goes down
        int x =  (b.getY()-playerH)/b.getVy(); // x means how many frames before catch the ball
         pred = b.getX()+(b.getVx()*x);  //# ¹w´ú³Ì²×¦ì¸m # pred means predict ball landing site 
        int bound = pred / 650;// # Determine if it is beyond the boundary
        if (bound > 0) { //# pred > 200 # fix landing position
            if (bound%2 == 0)  
                pred = pred - bound*650      ;              
            else 
                pred = 200 - (pred - 650*bound);
        }else if (bound < 0) {//# pred < 0
            if (bound%2 ==1) 
                pred = Math.abs(pred - (bound+1) *650);
            else 
                pred = pred + Math.abs(bound*650);
        }		
		}else {//ball goes up
        pred = 325;
		
		}
		
		if (playerx+75  > (pred-10) && playerx+75 < (pred+10))
			releaseX();
		else if (playerx+75 <= (pred-10) )
			 player_right(); //# goes right
	    else 
	    	player_left();
		
		
		
		
		playerx+=movex;
		toBall();
		if(playerx+playerW>Game.WIDTH)
			playerx=Game.WIDTH-playerW;
		else if(playerx<=0)
			playerx=0;
	}
}
