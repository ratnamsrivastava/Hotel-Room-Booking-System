package pack;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JFrame implements ActionListener{
	private JTextField name;
	private JPasswordField password;
	JButton submit,cancel;
	private JButton forgot;
	String user;
	char[]pass;
	String pwd;
	static String user1;
	ImageIcon ii,hh,oo;
	public Login() {
		
		getContentPane().setLayout(null);
		Container c=getContentPane();
		c.setBackground(Color.CYAN);
		
		ii=new ImageIcon("room.gif");
		hh=new ImageIcon("check.gif");
		oo=new ImageIcon("forgot.gif");
		JLabel n = new JLabel("User Name:");
		n.setFont(new Font("Alaska", Font.BOLD, 14));
		n.setBounds(20, 101, 97, 22);
		getContentPane().add(n);
		
		JLabel p = new JLabel("Password:");
		p.setFont(new Font("Alaska", Font.BOLD, 14));
		p.setBounds(20, 171, 89, 18);
		getContentPane().add(p);
		
		name = new JTextField();
		name.setForeground(new Color(0, 0, 128));
		name.setBounds(170, 102, 138, 21);
		getContentPane().add(name);
		name.setColumns(10);
		
		password = new JPasswordField();
		password.setForeground(new Color(0, 0, 128));
		password.setBounds(170, 169, 138, 23);
		getContentPane().add(password);
		
		submit = new JButton("Submit",hh);
		
		
		submit.setHorizontalAlignment(SwingConstants.RIGHT);
		submit.setForeground(new Color(0, 0, 0));
		submit.setFont(new Font("Algerian", Font.PLAIN, 16));
		submit.setBounds(314, 405, 138, 23);
		getContentPane().add(submit);
		
		JLabel log = new JLabel("LOGIN");
		log.setVerticalAlignment(SwingConstants.TOP);
		log.setFont(new Font("Jokerman", Font.PLAIN, 40));
		log.setForeground(Color.RED);
		log.setBounds(140, 11, 153, 47);
		getContentPane().add(log);
		
		 cancel = new JButton("Exit");
		 cancel.setForeground(new Color(0, 102, 0));
		 cancel.setFont(new Font("Algerian", Font.PLAIN, 14));
		cancel.setBounds(186, 481, 89, 23);
		getContentPane().add(cancel);
		
		forgot = new JButton("Forgot Password",oo);
		
		forgot.setFont(new Font("Algerian", Font.PLAIN, 16));
		forgot.setBounds(20, 405, 232, 23);
		getContentPane().add(forgot);
		
		JLabel pic = new JLabel(ii);
		pic.setBounds(596, 11, 647, 692);
		getContentPane().add(pic);
		setSize(getMaximumSize());
		submit.addActionListener(this);
		cancel.addActionListener(this);
		forgot.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we)
			{
				int yn;
				yn=JOptionPane.showConfirmDialog(null, "Sure to Exit", "Confirm Exit", JOptionPane.YES_NO_OPTION);
				if(yn==0)
				{
					System.exit(0);
				}
			}
		});
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		user1=name.getText();
		if(ob==cancel)
		{
			dispose();
		}
		else if(ob==submit)
		{	if(name.getText().length()==0)
			JOptionPane.showMessageDialog(null, "Fill Values");
			else if(password.getPassword().length==0)
			JOptionPane.showMessageDialog(null, "Fill Password");
			else
			{
				String user=name.getText();
			char pass[]=password.getPassword();
			String pwd=String.copyValueOf(pass);
				
				if(valid_log(user,pwd))
				{	
					JOptionPane.showMessageDialog(null, "Correct Credential");
					
					new Process();
					dispose();
				}
				else
				{	JOptionPane.showMessageDialog(null, "Incorrect Credential");
					
				}
				
		}
		}
		
		else if(ob==forgot)
		{
			new Retrieve();
			dispose();
		}
		
		else if(ob==submit)
		{
			String pass=new String(password.getPassword());
			String s="Select * from log where User_Name=? and Password=?";
			Connection c=MyConnection.getConnection();
			try
			{
				PreparedStatement ps=c.prepareStatement(s);
				ps.setString(1, user);
				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					new Hotel();
					
					
				}
				else
				{
					//JOptionPane.showMessageDialog(null, "invalid");
					password.setText("");
					name.setText("");
					name.requestFocusInWindow();
				}
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
					
	}
	
	boolean valid_log(String User_Name,String Password)
	{
		String s="Select * from log where User_Name=? and Password=?";
		Connection con=MyConnection.getConnection();
		
		try
		{
			
			PreparedStatement ps=con.prepareStatement(s);
			ps.setString(1,User_Name);
			ps.setString(2, Password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return true;
			else {
				return false;
			}
		}
		catch (SQLException se)
		{
			se.printStackTrace();
			return false;
			
			
		}
		
		
		
	}
}

