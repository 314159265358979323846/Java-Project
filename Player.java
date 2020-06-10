import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class Player extends JPanel
{
	public static ArrayList<Ball> balls=new ArrayList<Ball>();
	public static int base=1;
	public static int playerH=50;
	private int playerW=150;
	private int playerx=Game.WIDTH/2-playerW/2;
	private int playery=Game.HEIGHT-playerH;
	private int movex=0;
	private int person=0;
	private int change=0;
	private Image player;
	
	public Player(int person)
	{
		this.person=person;
		timer.start();
		switch(person)
		{
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
	
	public int player_left()
	{
		return movex=-5;
	}

	public int player_right()
	{
		return movex=5;
	}

	public int releaseX()
	{
		return movex=0;
	}
	
	public void move()
	{
		switch(change)
		{
			case 1://long
				if(playerW<250)
					playerW+=2;
				break;
			case 2://short
				if(playerW>100)
					playerW-=2;
				break;
			default:
				break;
		}
		toBall();
		playerx+=movex;
		if(playerx+playerW>Game.WIDTH)
			playerx=Game.WIDTH-playerW;
		else if(playerx<=0)
			playerx=0;
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(playerx,playery,playerW,playerH);
	}

	public static void popBall()
	{
		while(balls.size()!=base)
			balls.remove(balls.size()-1);
	}

	public void toBall()
	{
		for(Ball b:balls)
		{
			if(collision(b))
			{
				Random r=new Random();
				if((b.getX()+30<playerx)&&(b.getVx()>0))
					b.setVel(-b.getVx(),-b.getVy()+r.nextInt(6)-3);
				else if(b.getX()+30>playerx+playerW&&(b.getVx()<0))
					b.setVel(-b.getVx()+r.nextInt(6)-3,-b.getVy());
				else 	
			      b.setVel(b.getVx()+r.nextInt(6)-3,-b.getVy()+r.nextInt(6)-3);		
			}
		}
	}
	
	public Boolean collision(Ball b)
	{
		Rectangle ballRectangle=new Rectangle(b.getX()+b.getVx(),b.getY()+b.getVy(),60,60);
		Rectangle playerRectangle=new Rectangle(playerx+movex,playery,playerW,playerH);
		if(ballRectangle.getBounds().intersects(playerRectangle.getBounds()) || playerRectangle.getBounds().intersects(ballRectangle.getBounds()))
		{
			while(new Rectangle(b.getX()+b.getVx(),b.getY()+b.getVy(),60,60).getBounds().intersects(playerRectangle.getBounds()) || playerRectangle.getBounds().intersects(new Rectangle(b.getX()+b.getVx(),b.getY()+b.getVy(),60,60).getBounds()))
				b.setPos(b.getX()-b.getVx(),b.getY()-b.getVy());
			if(b.getX()+60>=Game.WIDTH)
				b.setPos(Game.WIDTH-60,b.getY());
			if(b.getX()<=0)
				b.setPos(0,b.getY());
			if(b.getY()+60>=Game.HEIGHT)
				b.setPos(b.getX(),Game.HEIGHT-60);
			if( b.getY()<=0)
				b.setPos(b.getX(),2);
			return true;
		}
		else
			return false;
	}
	
	public void computerMove(Ball b)
	{
		int pred;
		if(b.getVy()< 0)
		{
        	int x=(b.getY()-playerH)/b.getVy(); 
         	pred=b.getX()+(b.getVx()*x);  
        	int bound=pred/650;
        	if(bound>0)
			{ 
            	if(bound%2==0)  
                	pred=pred-bound*650;              
            	else 
                	pred=650-(pred-650*bound);
        	}
			else if(bound<0)
			{
            	if(bound%2==1) 
                	pred=Math.abs(pred-(bound+1)*650);
            	else 
                	pred=pred+Math.abs(bound*650);
        	}		
		}
		else
			pred=325;
		if(playerx+75 >(pred-10) && playerx+75<(pred+10))
			releaseX();
		else if(playerx+75<=(pred-10))
			player_right();
	    else 
	    	player_left();
		switch(change)
		{
			case 1://long
				if(playerW<250)
					playerW+=2;
				break;
			case 2://short
				if(playerW>100)
					playerW-=2;
				break;
			default:
				break;
		}
		playerx+=movex;
		toBall();
		if(playerx+playerW>Game.WIDTH)
			playerx=Game.WIDTH-playerW;
		else if(playerx<=0)
			playerx=0;
	}
	
	private Timer timer=new Timer(4000,new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			Random random=new Random();
			change=random.nextInt(2)+1;
			if(Main.stop==true)
				((Timer)e.getSource()).stop();	
		}		
	});
}
