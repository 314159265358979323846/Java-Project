import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Finish extends JFrame
{
	JLabel label;
	JButton button=new JButton("Quit");
	private int win;
	public Finish(int win)
	{
		setResizable(false);
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setUndecorated(true);
		setVisible(true);
		ImageIcon finish=new ImageIcon("img/finish.png");
		JLabel img=new JLabel(finish);
		getContentPane().add(img,null);
		img.setBounds(0,150,600,300);
		this.win=win;
		if(win==1)
			label=new JLabel("Player 1 Win");
		else if(win==2)
			label=new JLabel("Player 2 Win");
		else if(win==3)
			label=new JLabel("Computer Win");
		getContentPane().add(label,null);
		label.setBounds(150,50,400,100);
		label.setFont(new Font("Time News Roman",Font.BOLD,40));
		label.setForeground(Color.RED);
		getContentPane().add(button,null);
		button.setBounds(150,450,300,100);
		button.setFont(new Font("Time News Roman",Font.BOLD,32));
		button.setOpaque(false);
		button.setBackground(Color.BLUE);
		button.setForeground(Color.BLUE);
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});
	}
}
