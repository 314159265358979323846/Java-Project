import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame
{
	JButton button1=new JButton("PC GAME");
	JButton button2=new JButton("ONLINE MODE");
	JButton button3=new JButton("QUIT");
	public Menu()
	{
		super();
		this.setResizable(false);
		this.setSize(600,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("MENU");
		this.setLayout(null);
		this.setVisible(true);
		Font font=new Font("Time News Roman",Font.BOLD,48);
		Font font2=new Font("Time News Roman",Font.BOLD,30);
		this.getContentPane().add(button1,null);
		button1.setBounds(150,100,300,100);
		button1.setFont(font);
		this.getContentPane().add(button2,null);
		button2.setBounds(150,250,300,100);
		button2.setFont(font2);
		this.getContentPane().add(button3,null);
		button3.setBounds(150,400,300,100);
		button3.setFont(font);

		button1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Main main=new Main();
					setVisible(false);
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
