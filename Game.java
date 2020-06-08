

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Game extends JPanel
{
	static final int WIDTH=650;
	static final int HEIGHT=850;
	private Image background=new ImageIcon("img/background.png").getImage();
	Player player1=new Player(1);
	Player player2=new Player(2);
	public Game()
	{
		Player.addBall(new Ball());
//		Player.addBall(new Ball(10, 10, 5, 5));
//		Player.addBall(new Ball(200, 200, 5, -5));
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
    public Boolean isWin() {
    	if(Player.balls.get(0).getY()<=(Player.playerH/3)) {//||Player.balls.get(0).getY()>=(Game.HEIGHT-60)) {
    		Player.winner=1;
    		return true;
    	}else if(Player.balls.get(0).getY()+60>=(Game.HEIGHT-2)){
    		if(Menu.person==1)
    			 Player.winner=3;
    		else 
    			Player.winner=2;
		    return true;
    	}else{
			return false;
		}
	}
	public void move()
	{
		player1.move();
		if(Menu.person==2) {
			  player2.move();
			}else {
				player2.computerMove(Player.balls.get(0));
			}
	    Player.balls.forEach(ball ->ball.move());
	}
}