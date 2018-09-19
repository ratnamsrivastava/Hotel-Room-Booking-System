package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Retrieve extends JDialog implements ActionListener{
	private JPasswordField a;
	private JTextField u;
	private JTextField q;
	private JTextField p;
	JButton back,get;
	String tans,uans,pass;
	public Retrieve() {
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(42, 68, 72, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblQuestion = new JLabel("Question:");
		lblQuestion.setBounds(42, 119, 72, 14);
		getContentPane().add(lblQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setBounds(42, 155, 72, 14);
		getContentPane().add(lblAnswer);
		
		 get = new JButton("Get Password");
		get.setBounds(146, 193, 163, 23);
		getContentPane().add(get);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(42, 254, 72, 14);
		getContentPane().add(lblPassword);
		
		back = new JButton("Back To Login");
		back.setBounds(192, 345, 135, 23);
		getContentPane().add(back);
		
		a = new JPasswordField();
		a.setText("");
		a.setBounds(153, 152, 263, 20);
		getContentPane().add(a);
		
		u = new JTextField(Login.user1);
		u.setEditable(false);
		u.setBounds(146, 65, 220, 20);
		getContentPane().add(u);
		u.setColumns(10);
		
		q = new JTextField();
		q.setEditable(false);
		q.setColumns(10);
		q.setBounds(146, 116, 270, 20);
		getContentPane().add(q);
		
		p = new JTextField();
		p.setEditable(false);
		p.setColumns(10);
		p.setBounds(164, 251, 145, 20);
		getContentPane().add(p);
		get.addActionListener(this);
		back.addActionListener(this);
		fillInfo();
		setSize(700,700);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Retrieve();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object b=e.getSource();
		if(b==back)
		{
			new Login();
			dispose();
			
		}
		else if(b==get)
		{
			uans =new String(a.getPassword()); 	
			if(tans.equals(uans))
			{
				p.setText(pass);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Wrong answer");
				a.setText("");
				a.requestFocusInWindow();
			}
		}
		
	}
void fillInfo()
{
	String s="Select * from log where User_Name=?";
	Connection c=MyConnection.getConnection();
	try
	{
		PreparedStatement ps=c.prepareStatement(s);
		ps.setString(1,Login.user1);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			pass=rs.getString("Password");
			tans=rs.getString("answer");
			q.setText(rs.getString("question"));
			
		}
		
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
}
}
