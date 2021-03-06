import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mode extends JFrame
{
	JButton button1=new JButton("Normal");
	JButton button2=new JButton("Special");
	JButton button3=new JButton("Return");
	JLabel label=new JLabel("Game Mode");
	static String mode="";
	final Sound sound=Sound.getInstance();
	public Mode()
	{
		mode="";
		setResizable(false);
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
		ImageIcon menu=new ImageIcon("img/mode.png");
		JLabel img=new JLabel(menu);
		getLayeredPane().add(img,Integer.valueOf(Integer.MIN_VALUE));
		img.setBounds(0,0,600,600);
		Container contain=this.getContentPane();
		((JPanel) contain).setOpaque(false);
		contain.add(label);
		label.setBounds(150,0,300,100);
		label.setFont(new Font("Time News Roman",Font.BOLD | Font.ITALIC,48));
		label.setForeground(Color.RED);
		Font font=new Font("Time News Roman",Font.BOLD,32);
		contain.add(button1);
		button1.setBounds(150,100,300,100);
		button1.setFont(font);
		button1.setOpaque(false);
		button1.setBackground(Color.YELLOW);
		button1.setForeground(Color.YELLOW);
		button1.setBorderPainted(false);
		contain.add(button2);
		button2.setBounds(150,250,300,100);
		button2.setFont(font);
		button2.setOpaque(false);
		button2.setBackground(Color.YELLOW);
		button2.setForeground(Color.YELLOW);
		button2.setBorderPainted(false);
		contain.add(button3);
		button3.setBounds(150,400,300,100);
		button3.setFont(font);
		button3.setOpaque(false);
		button3.setBackground(Color.YELLOW);
		button3.setForeground(Color.YELLOW);
		button3.setBorderPainted(false);

		button1.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					mode="normal";
					sound.play("button.wav");
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
					sound.play("circle.wav");
					sound.play("button.wav");
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
					sound.play("button.wav");
					Menu.music.stop();
					dispose();
				}
			});
	}
}
