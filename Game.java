import java.awt.*;
import java.awt.event.*;
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
import javax.swing.*;

public class Game extends JPanel
{
	static final int WIDTH=650;
	static final int HEIGHT=850;
	private Image background=new ImageIcon("img/background.png").getImage();
	Player player1=new Player(1);
	Player player2=new Player(2);
	public Game()
	{
		Player.base = 1;
		Player.addBall(new Ball());
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
							if(Menu.person==2)
							 player2.player_left();
							break;
						case KeyEvent.VK_D:
							if(Menu.person==2)
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
							if(Menu.person==2)
							 player2.releaseX();
							break;
						case KeyEvent.VK_D:
							if(Menu.person==2)
							 player2.releaseX();
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
		super.paint(g);
		g.drawImage(background,0,0,null);
		player1.paint(g);
		player2.paint(g);
		Player.balls.forEach(ball->ball.paint(g));
	}
    public int isWin()
	{
    	if(Player.balls.get(0).getY()<=(Player.playerH/3))
    		return 1;
    	else if(Player.balls.get(0).getY()+Ball.ballW>=(Game.HEIGHT-2))
		{
    		if(Menu.person==1)
				return 3;
    		else 
    			return 2;
    	}
		return 0;
	}
	public void move()
	{
		player1.move();
		if(Menu.person==2)
			player2.move();
		else
			player2.computerMove(Player.balls.get(0));
	    Player.balls.forEach(ball->ball.move());
	}
/*	public static synchronized void playSound(final String url)
	{
		new Thread(new Runnable()
		{
		    public void run()
			{
				try
				{
					Clip clip=AudioSystem.getClip();
					AudioInputStream inputStream=AudioSystem.getAudioInputStream(Main.class.getResourceAsStream("/sound/"+url));
					clip.open(inputStream);
					clip.start(); 
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}).start();
	}*/
}
