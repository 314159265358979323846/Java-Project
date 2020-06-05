import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame
{
	public Main()
	{
		super("PC GAME");
		setResizable(false);
		setSize(Game.WIDTH,Game.HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
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
		this.add(game);
		this.setVisible(true);
		timer.start();

	}
}
