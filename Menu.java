import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame
{
	JButton button1=new JButton("1 Player");
	JButton button2=new JButton("2 Player");
	JButton button3=new JButton("Quit");
	JLabel label=new JLabel("Game Menu");
	static Music music=new Music();
	final Sound sound=Sound.getInstance();
	static int person=0;
	public Menu()
	{
		music.play("sao.wav");
		person=0;
		setResizable(false);
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setUndecorated(true);
		setVisible(true);
		ImageIcon menu=new ImageIcon("img/menu.png");
		JLabel img=new JLabel(menu);
		getLayeredPane().add(img,Integer.valueOf(Integer.MIN_VALUE));
		img.setBounds(0,0,600,600);
		Container contain=this.getContentPane();
		((JPanel) contain).setOpaque(false);
		contain.add(label);
		label.setBounds(100,250,300,100);
		label.setFont(new Font("Time News Roman",Font.BOLD | Font.ITALIC,48));
		label.setForeground(Color.RED);
		Font font=new Font("Time News Roman",Font.BOLD,32);
		contain.add(button1);
		button1.setBounds(400,100,200,100);
		button1.setFont(font);
		button1.setOpaque(false);
		button1.setBackground(Color.BLUE);
		button1.setForeground(Color.BLUE);
		button1.setBorderPainted(false);
		contain.add(button2);
		button2.setBounds(400,250,200,100);
		button2.setFont(font);
		button2.setOpaque(false);
		button2.setBackground(Color.BLUE);
		button2.setForeground(Color.BLUE);
		button2.setBorderPainted(false);
		contain.add(button3);
		button3.setBounds(400,400,200,100);
		button3.setFont(font);
		button3.setOpaque(false);
		button3.setBackground(Color.BLUE);
		button3.setForeground(Color.BLUE);
		button3.setBorderPainted(false);

		button1.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					person=1;
					sound.play("button.wav");
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
					sound.play("button.wav");
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
