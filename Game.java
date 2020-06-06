import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JPanel
{
	static final int WIDTH=600;
	static final int HEIGHT=800;
	private Image background=new ImageIcon("img/background.png").getImage();
	Player player1=new Player("normal",1);
	Player player2=new Player("normal",2);
	public Game()
	{
		Player.addBall(new Ball());
		Player.addBall(new Ball(10, 10, 4, 5));
		this.setFocusable(true);
		this.addKeyListener(new KeyListener()
			{
				public void keyPressed(KeyEvent e)
				{
					switch(e.getKeyCode())
					{
						
						case KeyEvent.VK_LEFT:
							player1.player_left();
							break;
						case KeyEvent.VK_RIGHT:
							player1.player_right();
							break;
						case KeyEvent.VK_A:
							player2.player_left();
							break;
						case KeyEvent.VK_D:
							player2.player_right();
							break;
						default:
							break;
					}
				}
				public void keyReleased(KeyEvent e)
				{
					switch (e.getKeyCode())
					{
						case KeyEvent.VK_LEFT:
							player1.releaseX();
							break;
						case KeyEvent.VK_RIGHT:
							player1.releaseX();
							break;
						case KeyEvent.VK_A:
							player2.releaseX();
							break;
						case KeyEvent.VK_D:
							player2.releaseX();
							break;
						default:
							break;
					}
				}
			
							
				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}});
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(background,0,0,null);
		player2.paint(g);
		player1.paint(g);
		Player.balls.forEach(ball ->ball.paint(g));
	}
	public void move()
	{
		player1.move();
		player2.move();
	    Player.balls.forEach(ball ->ball.move());
	}
}
