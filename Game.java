import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JPanel
{
	static final int WIDTH=600;
	static final int HEIGHT=800;
	Player player1=new Player();
	Player player2=new Player();
	Ball ball=new Ball();
	public Game()
	{
		Ball.setPlayer(player1, player2);
		this.setFocusable(true);
		this.addKeyListener(new KeyListener()
			{
				public void keyPressed(KeyEvent e)
				{
					switch(e.getKeyCode())
					{
						case KeyEvent.VK_UP:
							Player.player_up();
							break;
						case KeyEvent.VK_DOWN:
							Player.player_down();
							break;
						case KeyEvent.VK_LEFT:
							Player.player_left();
							break;
						case KeyEvent.VK_RIGHT:
							Player.player_right();
							break;
						default:
							break;
					}
				}
				public void keyReleased(KeyEvent e)
				{
					switch (e.getKeyCode())
					{
						case KeyEvent.VK_UP:
						case KeyEvent.VK_DOWN:
							Player.releaseY();
							break;
						case KeyEvent.VK_LEFT:
						case KeyEvent.VK_RIGHT:
							Player.releaseX();
							break;
						default:
							break;
					}
				}
				public void keyTyped(KeyEvent e) {}
			});
	}
	public void paint(Graphics g)
	{
		player1.paint(g);
		player2.paint(g);
		ball.paint(g);
	}
	public void move()
	{
		player1.move();
		player2.move();
	    ball.move();
	}
}
