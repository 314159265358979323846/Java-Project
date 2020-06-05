import java.awt.*;
import javax.swing.*;
public class Ball extends JPanel
{
	Player player=new Player();
	private static int ballW=60;
	private static int ballH=60;
	private static int ballx=Game.WIDTH/2-ballW/2;
	private static int bally=Game.HEIGHT/2-ballH/2;
	private int pScore=0;
	private int cScore=0;
	private String p_score="0";
	private String c_score="0";
	private Image ball;
	public void score1()
	{
		pScore+=1;
		p_score=Integer.toString(pScore);
	}
	public void score2()
	{
		cScore+=1;
		c_score=Integer.toString(cScore);
	}
	public void move()
	{
		ball=new ImageIcon("img/ball.png").getImage();
/*		//player win the score
		if()
		{
			score1();
		}
		//computer win the score
		else if()
		{
			score2();
		}
*/
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setFont(new Font("Times New Roman",Font.BOLD,48));
		g.setColor(Color.BLUE);
		g.drawString(p_score,50,50);
		g.setColor(Color.RED);
		g.drawString(c_score,550,50);
		g.drawImage(ball,ballx,bally,null);
	}
}
