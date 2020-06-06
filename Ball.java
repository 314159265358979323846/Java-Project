import java.awt.*;
import javax.swing.*;
public class Ball extends JPanel
{
	public Ball() 
	{
		setPos(Game.WIDTH/2-ballW/2, Game.HEIGHT/2-ballH/2);
		setVel(0, 0);
		ball=new ImageIcon("img/ball.png").getImage();
	}
	
	public Ball(int x, int y, int vx, int vy)
	{
		setPos(x, y);
		setVel(vx, vy);
		ball=new ImageIcon("img/ball.png").getImage();
	}
	
	public static void setPlayer(Player p1, Player p2)
	{
		player1 = p1;
		player2 = p2;
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
		ballx += vx;
		bally += vy;
		if(ballx + ballW >= Game.WIDTH || ballx <= 0)
			vx = -vx;
		if(bally + ballH >= Game.HEIGHT || bally <= 0)
			vy = -vy;
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
	private Image ball;
	private static Player player1, player2;
}
