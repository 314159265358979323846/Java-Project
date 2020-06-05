import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main
{
	static JFrame frame = new JFrame();
	public static void main(String args[])
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Game.WIDTH,Game.HEIGHT);
		frame.setLocationRelativeTo(null);
	    //frame.setUndecorated(true);
		Game game=new Game();
		Timer timer=new Timer(5,new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					game.move();
					game.repaint();
				}
			});
		game.setVisible(true);
		frame.add(game);
		frame.setVisible(true);
		timer.start();
	}
}
