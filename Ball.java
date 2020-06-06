import java.awt.*;
import javax.swing.*;
public class Ball extends JPanel
{
	public Ball() 
	{
		setPos(Game.WIDTH/2-ballW/2, Game.HEIGHT/2-ballH/2);
		setVel(3, 3);
		ball=new ImageIcon("img/ball.png").getImage();
	}
	
	public Ball(int x, int y, int vx, int vy)
	{
		setPos(x, y);
		setVel(vx, vy);
		ball=new ImageIcon("img/ball.png").getImage();
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
		this.vx = vx;
		this.vy = vy;
	}
	
	public void move()
	{
//		System.out.printf("%d %d\n", vx, vy);
		ballx += vx;
		bally += vy;
		ballCollision();
		if(ballx + ballW >= Game.WIDTH || ballx <= 0)
			vx = -vx;
		if(bally + ballH >= Game.HEIGHT || bally <= 0)
			vy = -vy;
	}
	
	private void ballCollision()
	{
		for(Ball ball: Player.balls)
		{
			if(this != ball)
			{
				int centerx = ballx + ballW/2, centery = bally + ballH/2;
				int bx = ball.ballx + ballW/2, by = ball.bally + ballH/2;
				if(Math.pow(centerx - bx, 2) +Math.pow(centery - by,  2) <= Math.pow(ballW, 2))
				{
					
//					System.out.println(tt++);
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
//					System.out.printf("%d %d\n", Math.round(_vx + _vxN), Math.round(_vy + _vyN));
					vx = (int)Math.round(_vx + _vxN);
					vy = (int)Math.round(_vy + _vyN);
					ball.vx = (int)Math.round(vx_ + vxN_);
					ball.vy = (int)Math.round(vy_ + vyN_);					
				}
			}
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(ball,ballx,bally,null);
	}
	
	private static int ballW = 60;
	private static int ballH = 60;
	private int ballx;
	private int bally;
	private int vx;
	private int vy;
	static int tt = 0;
	private Image ball;
}
