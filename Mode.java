import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mode extends JFrame
{
	static String mode;
	JButton button1=new JButton("Normal");
	JButton button2=new JButton("Special");
	JButton button3=new JButton("Return");
	JLabel label=new JLabel("Game Mode");
	public Mode()
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
					mode="normal";
					Main main=new Main();
					dispose();
				}
			});
		button2.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					mode="special";
					Main main=new Main();
					dispose();
				}
			});
		button3.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					Menu menu=new Menu();
					dispose();
				}
			});
	}
}
