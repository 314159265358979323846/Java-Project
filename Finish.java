import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Finish extends JFrame
{
	JLabel label;
	JButton button=new JButton("Quit");
	JButton button2=new JButton("Restart");
	private int win;
	public Finish(int win)
	{
		setResizable(false);
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.GRAY);
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
		getContentPane().add(button1,null);
		button1.setBounds(350,450,200,100);
		button1.setFont(new Font("Time News Roman",Font.BOLD,32));
		button1.setOpaque(false);
		button1.setBackground(Color.BLUE);
		button1.setForeground(Color.BLUE);
		button1.setBorderPainted(false);
		getContentPane().add(button2,null);
		button2.setBounds(50,450,200,100);
		button2.setFont(new Font("Time News Roman",Font.BOLD,32));
		button2.setOpaque(false);
		button2.setBackground(Color.BLUE);
		button2.setForeground(Color.BLUE);
		button2.setBorderPainted(false);
		button1.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});
		button2.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					dispose();
					Menu menu=new Menu();
				}
			});
	}
}
