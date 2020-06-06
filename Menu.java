import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame
{
	JButton button1=new JButton("1 Player");
	JButton button2=new JButton("2 Player");
	JButton button3=new JButton("Quit");
	JLabel label=new JLabel("Game Menu");
	static int person;
	public Menu()
	{
		setResizable(false);
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
		getContentPane().add(label,null);
		label.setBounds(150,0,300,100);
		label.setFont(new Font("Time News Roman",Font.BOLD | Font.ITALIC,48));
		Font font=new Font("Time News Roman",Font.BOLD,32);
		getContentPane().add(button1,null);
		button1.setBounds(150,100,300,100);
		button1.setFont(font);
		getContentPane().add(button2,null);
		button2.setBounds(150,250,300,100);
		button2.setFont(font);
		getContentPane().add(button3,null);
		button3.setBounds(150,400,300,100);
		button3.setFont(font);

		button1.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					person=1;
					Mode mode=new Mode();
					dispose();
				}
			});
		button2.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					person=2;
					Mode mode=new Mode();
					dispose();
				}
			});
		button3.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});
	}
	public static void main(String[] args)
	{
		new Menu();
	}
}
