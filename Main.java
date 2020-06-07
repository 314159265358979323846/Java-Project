import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame
{
	JLabel point1=new JLabel("0");
	JLabel point2=new JLabel("0");
	JLabel label1=new JLabel("Lose Ball:");
	JLabel label2=new JLabel("Lose Ball:");
	public Main()
	{
		setResizable(false);
		Font font=new Font("Time News Roman",Font.BOLD,32);
		if(Mode.mode.contentEquals("special"))
			setSize(Game.WIDTH,900);
		else
			setSize(Game.WIDTH,Game.HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
		if(Mode.mode.contentEquals("special"))
		{
			getContentPane().add(label1,null);
			label1.setBounds(0,850,200,50);
			label1.setFont(font);
			getContentPane().add(label2,null);
			label2.setBounds(325,850,200,50);
			label2.setFont(font);
		}
		Game game=new Game();
		Timer timer=new Timer(5,new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					game.move();
					game.repaint();
					if(Mode.mode.contentEquals("special"))
					{
						point1.setText(String.valueOf(Ball.player1));
						getContentPane().add(point1,null);
						point1.setBounds(200,850,100,50);
						point1.setFont(font);
						
						point2.setText(String.valueOf(Ball.player2));
						getContentPane().add(point2,null);
						point2.setBounds(525,850,100,50);
						point2.setFont(font);
						if(Ball.player1==5 && Menu.person==2)
						{
							((Timer)e.getSource()).stop();
							Finish finish=new Finish(2);
							dispose();
						}
					}
				}
			});
		game.setVisible(true);
		add(game);
		game.setBounds(0,0,Game.WIDTH,Game.HEIGHT);
		timer.start();
	}
}
