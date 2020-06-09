import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
public class Ball extends JPanel
{
	public static int player1= 0;
	public static int player2 = 0;
	public Ball() 
	{
		this(Game.WIDTH/2-ballW/2, Game.HEIGHT/2-ballH/2, 1,1);
	}
	
	public Ball(int x, int y, int vx, int vy)
	{
		setPos(x, y);
		setVel(vx, vy);
		deg = rdn.nextDouble();
		ball=new ImageIcon("img/ball.png").getImage();
		special = 0;
		if(Mode.mode.contentEquals("special"))
			timer.start();
	}
	
	public int getVx()
	{
		return vx;
	}
	
	public int getVy()
	{
		return vy;
	}
	
	public int getX()
	{
		return ballx;
	}
	
	public int getY()
	{
		return bally;
	}
	
	public void setPos(int x, int y)
	{
		ballx = x;
		bally = y;
	}
	
	public void setVel(int vx, int vy)
	{
		special = 0;
		Game.playSound("bounce.wav");
		this.vx = vx;
		this.vy = vy;
	}
	
	public void move()
	{
		if(special == 1)
			circle();
		else if(special == 2 || special == 3)
			wave();
		else if (special  == 0 && (Math.pow(vx, 2) + Math.pow(vy, 2) > 100))
			slowDown();
		if(vx == 0)
			vx = rdn.nextInt(4)+1;
		if(vy == 0)
			vy = rdn.nextInt(4)+1;
		ballCollision();
		ballx += vx;
		bally += vy;
		if(ballx + ballW >= Game.WIDTH || ballx <= 0)
		{
			Game.playSound("bounce.wav");
			vx = -vx;
			ballx += vx;
//			special = 0;
		}
		if(bally + ballH >= Game.HEIGHT || bally <= 0)
		{
			if(Mode.mode.contentEquals("special"))
			{
				if(bally <= 0)
					player2++;
				else
					player1++;
//				System.out.printf("1p: %d 2p : %d\n", player1, player2);
			}
			Game.playSound("bounce.wav");
			vy = -vy;
			bally += vy;
//			special = 0;
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(ball,ballx,bally,null);
	}
	
	private void slowDown()
	{
		double rate = 1.2;
		vx /= rate;
		vy /= rate;
	}
	private void circle()
	{
		v = Math.sqrt(Math.pow(vx, 2) + Math.pow(vy, 2) );
		vx = (int)Math.round(Math.sin(deg) * v);
		vy = (int)Math.round(Math.cos(deg) * v);
		deg += 0.1;
	}
	
	private void wave()
	{
		if(special == 2)
			vx = (int)Math.round(Math.sin(deg) * v);
		else
			vy = (int)Math.round(Math.sin(deg) * v);
		deg += 0.1;
	}
	
	private void ballCollision()
	{
		for(Ball ball: Player.balls)
		{
			if(this != ball)
			{
				int centerx = ballx + ballW/2 + vx, centery = bally + ballH/2 + vy;
				int bx = ball.ballx + ballW/2 + ball.vx, by = ball.bally + ballH/2 + ball.vy;
				if(Math.pow(centerx - bx, 2) +Math.pow(centery - by,  2) <= Math.pow(ballW, 2))
				{
					Game.playSound("collide.wav");
					special = 0;
					ball.special = 0;
					double ux = (bx - centerx)/Math.sqrt(Math.pow(centerx - bx, 2) +Math.pow(centery - by,  2));
					double uy = (by - centery)/Math.sqrt(Math.pow(centerx - bx, 2) +Math.pow(centery - by,  2)); // unit vector
					double vx_ = (vx * (bx - centerx) + vy * (by - centery)) * ux/Math.sqrt(Math.pow(centerx - bx, 2) +Math.pow(centery - by,  2));
					double vy_ = (vx * (bx - centerx) + vy * (by - centery)) * uy/Math.sqrt(Math.pow(centerx - bx, 2) +Math.pow(centery - by,  2));
					double _vx = (ball.vx * (centerx - bx) + ball.vy * (centery - by)) * (-ux)/Math.sqrt(Math.pow(centerx - bx, 2) +Math.pow(centery - by,  2));
					double _vy = (ball.vx * (centerx - bx) + ball.vy * (centery - by)) * (-uy)/Math.sqrt(Math.pow(centerx - bx, 2) +Math.pow(centery - by,  2));
					double _vxN = vx - vx_;
					double _vyN = vy - vy_;
					double vxN_ = ball.vx - _vx;
					double vyN_ = ball.vy - _vy;
					vx = (int)Math.round(_vx + _vxN);
					vy = (int)Math.round(_vy + _vyN);
					ball.vx = (int)Math.round(vx_ + vxN_);
					ball.vy = (int)Math.round(vy_ + vyN_);					
				}
			}
		}
	}
	
	private Timer timer=new Timer(5000,new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			if((special == 1 || special == 2 || special == 3) && deg < 3.14)
				return;
			if(del)
			{
				Player.popBall();
				del = false;
			}
			int temp = rdn.nextInt(6);
			while(temp == special)
				temp = rdn.nextInt(6);
			special = temp;
			if(special == 1 || special == 2 || special == 3)
				deg = 0;
			if(special == 1)
				Game.playSound("circle.wav");
			else if(special == 2)
			{
				Game.playSound("wave.wav");
				v = vx;
			}
			else if(special == 3)
			{
				Game.playSound("wave.wav");
				v = vy;
			}
			else if(special == 4)
			{
				Game.playSound("split.wav");
				del = true;
				int fold = 2;
				Player.addBall(new Ball(ballx - ballW, bally + ballW, vx/fold + 1, vy/fold + 1));
				Player.addBall(new Ball(ballx + ballW, bally + ballW, vx/fold + 1, vy/fold + 1));
				Player.addBall(new Ball(ballx - ballW, bally - ballW, vx/fold + 1, vy/fold + 1));
				Player.addBall(new Ball(ballx + ballW, bally - ballW, vx/fold + 1, vy/fold + 1));
			}
			else if(special == 5)
			{
				if(Player.base < 3)
				{
					Game.playSound("split.wav");
					Player.base++;
					Player.addBall(new Ball(ballx - ballW, bally + ballW, vx, vy));
				}
				special = 1;
			}
//			System.out.println(special);
		}// 1-5
	});
	
	private static int ballW = 60;
	private static int ballH = 60;
	private int ballx;
	private int bally;
	private int vx;
	private int vy;
	private int special;
	private double deg = 0;
	private static Random rdn = new Random();
	private double v; 
	private static boolean del = false;
	private Image ball;
}
