import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame
{
	JButton button1=new JButton("單機遊戲");
	JButton button2=new JButton("連線遊戲");
	JButton button3=new JButton("離開遊戲");
	public Menu()
	{
		super();
		this.setResizable(false);
		this.setSize(600,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("主選單");
		this.setLayout(null);
		this.setVisible(true);
		Font font=new Font("Time News Roman",Font.BOLD,48);
		this.getContentPane().add(button1,null);
		button1.setBounds(150,100,300,100);
		button1.setFont(font);
		this.getContentPane().add(button2,null);
		button2.setBounds(150,250,300,100);
		button2.setFont(font);
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
