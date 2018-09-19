package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.SystemColor;

public class Welcome extends JFrame implements ActionListener {
	JButton login;
	JLabel logpic,hotellbl;
	ImageIcon ii,hh;
	public Welcome() {
		getContentPane().setLayout(null);
		ii=new ImageIcon("login.gif");
		hh=new ImageIcon("hotelveg.gif");
		
		JLabel wel = new JLabel("Welcome To The Rosewood Hotel...");
		wel.setFont(new Font("Jokerman", Font.PLAIN, 30));
		wel.setForeground(SystemColor.desktop);
		wel.setBounds(553, 11, 545, 42);
		getContentPane().add(wel);
		
		 login = new JButton("Login");
		login.setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 26));
		login.setBounds(1186, 624, 140, 31);
		getContentPane().add(login);
		
		logpic = new JLabel(ii);
		logpic.setBounds(1022, 608, 154, 66);
		getContentPane().add(logpic);
		
		hotellbl = new JLabel(hh);
		hotellbl.setBounds(10, 64, 1342, 666);
		getContentPane().add(hotellbl);
		setSize(getMaximumSize());
		login.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Welcome();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==login)
		{
			new Login();
			dispose();
		}
				
	}
}
