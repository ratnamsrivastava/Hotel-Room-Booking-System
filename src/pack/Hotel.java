package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import java.awt.Color;

public class Hotel extends JFrame implements ActionListener{
	ImageIcon hh;
	JButton check,cancel,back;
	
	
	public Hotel() {
		getContentPane().setLayout(null);
		
		
		hh=new ImageIcon("dub.gif");
		
	
		
		
		JLabel lblNewLabel = new JLabel("WELCOME TO THE ROSEWOOD HOTEL...");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 39));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(288, 11, 1050, 56);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("THIS IS ONE OF THE BEST FIVE STAR HOTEL OF THE CITY..");
		lblNewLabel_1.setFont(new Font("Jokerman", Font.BOLD, 32));
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(165, 199, 1092, 44);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("   WE OFFER BEST SERVICES TO THE CUSTOMER.");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("Jokerman", Font.BOLD, 32));
		lblNewLabel_2.setForeground(Color.YELLOW);
		lblNewLabel_2.setBounds(153, 254, 853, 49);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("WE MAKE THE CLIENTS FEEL HOME..");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setFont(new Font("Jokerman", Font.BOLD, 32));
		lblNewLabel_3.setForeground(Color.YELLOW);
		lblNewLabel_3.setBounds(137, 314, 912, 44);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("WE ALSO PROVIDE MEETING AND CONFERENCE HALL SERVICES..");
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setFont(new Font("Jokerman", Font.BOLD, 32));
		lblNewLabel_4.setBounds(89, 369, 1202, 44);
		getContentPane().add(lblNewLabel_4);
		
		check = new JButton("Check Availablity");
		check.setBackground(Color.LIGHT_GRAY);
		check.setFont(new Font("Algerian", Font.BOLD, 16));
		check.setForeground(new Color(0, 0, 0));
		check.setBounds(869, 660, 251, 23);
		getContentPane().add(check);
		
		cancel = new JButton("Cancel");
		cancel.setFont(new Font("Algerian", Font.BOLD, 16));
		cancel.setBackground(Color.LIGHT_GRAY);
		cancel.setBounds(702, 660, 132, 23);
		getContentPane().add(cancel);
		
		JLabel pic = new JLabel(hh);
		pic.setBounds(-51, 11, 1342, 642);
		getContentPane().add(pic);
		
		back = new JButton("Back");
		back.setFont(new Font("Algerian", Font.BOLD, 16));
		back.setBounds(1161, 661, 89, 23);
		getContentPane().add(back);
		check.addActionListener(this);
		cancel.addActionListener(this);
		back.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we)
			{
				int yn;
				yn=JOptionPane.showConfirmDialog(null, "Sure to Exit", "Swings", JOptionPane.YES_NO_OPTION);
				if(yn==0)
				{
					System.exit(0);
				}
			}
		});
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		setSize(getMaximumSize());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Hotel();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==cancel)
		{
			dispose();
		}
		else if(ob==check)
		{	
			
				new AvailableAll();
				dispose();
		}
		else if(ob==back)
		{
			new Process();
		}
	}
	}
