package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Color;



public class EmpUpdate extends JDialog implements ActionListener{
	private JTextField txteid;
	int id;
	private JTextField textname;
	private JTextField textdesig;
	private JTextField textmob;
	private JTextField textmail;
	private JTextField textuser;
	JRadioButton male,female;
	private JPasswordField textpass;
	JButton update,exit;
	ImageIcon ii;
	private JLabel pic;
	String user;
	public EmpUpdate(int id) {
		// TODO Auto-generated constructor stub
		this.id=id;
		getContentPane().setLayout(null);
		
		ii=new ImageIcon("top.gif");
		JLabel name = new JLabel("Id:");
		name.setFont(new Font("Tahoma", Font.BOLD, 14));
		name.setBounds(38, 11, 46, 14);
		getContentPane().add(name);
		
		txteid = new JTextField(String.valueOf(id));
		txteid.setFont(new Font("Tahoma", Font.BOLD, 14));
		txteid.setEnabled(false);
		txteid.setBounds(135, 8, 144, 20);
		getContentPane().add(txteid);
		txteid.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(38, 56, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(38, 95, 62, 14);
		getContentPane().add(lblGender);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDesignation.setBounds(38, 139, 95, 17);
		getContentPane().add(lblDesignation);
		
		JLabel lblMobileNo = new JLabel("Mobile No.:");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNo.setBounds(38, 183, 84, 14);
		getContentPane().add(lblMobileNo);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(38, 237, 70, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserName.setBounds(38, 300, 84, 14);
		getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(38, 359, 84, 14);
		getContentPane().add(lblPassword);
		
		textname = new JTextField();
		textname.setEnabled(false);
		textname.setBounds(151, 53, 194, 20);
		getContentPane().add(textname);
		textname.setColumns(10);
		
		textdesig = new JTextField();
		textdesig.setColumns(10);
		textdesig.setBounds(151, 136, 194, 20);
		getContentPane().add(textdesig);
		
		textmob = new JTextField();
		textmob.setColumns(10);
		textmob.setBounds(151, 180, 194, 20);
		getContentPane().add(textmob);
		
		textmail = new JTextField();
		textmail.setColumns(10);
		textmail.setBounds(151, 234, 194, 20);
		getContentPane().add(textmail);
		
		textuser = new JTextField();
		textuser.setColumns(10);
		textuser.setBounds(162, 297, 194, 20);
		getContentPane().add(textuser);
		
		textpass = new JPasswordField();
		textpass.setBounds(162, 356, 183, 20);
		getContentPane().add(textpass);
		
		 male = new JRadioButton("Male");
		male.setEnabled(false);
		male.setFont(new Font("Tahoma", Font.BOLD, 14));
		male.setBounds(142, 91, 109, 23);
		getContentPane().add(male);
		
		 female = new JRadioButton("Female");
		female.setEnabled(false);
		female.setFont(new Font("Tahoma", Font.BOLD, 14));
		female.setBounds(279, 91, 109, 23);
		getContentPane().add(female);
		
		exit = new JButton("Exit");
		exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		exit.setForeground(Color.RED);
		exit.setBounds(50, 454, 89, 23);
		getContentPane().add(exit);
		
		 update = new JButton("Update");
		update.setForeground(Color.BLUE);
		update.setFont(new Font("Tahoma", Font.BOLD, 14));
		update.setBounds(267, 454, 89, 23);
		getContentPane().add(update);
		ButtonGroup bg=new ButtonGroup();
		bg.add(female);
		bg.add(male);
		
		pic = new JLabel(ii);
		pic.setBounds(394, 97, 604, 206);
		getContentPane().add(pic);
		exit.addActionListener(this);
		update.addActionListener(this);
		setSize(1024, 1080);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we)
			{
				int yn;
				yn=JOptionPane.showConfirmDialog(null, "Sure to Exit", "Swings", JOptionPane.YES_NO_CANCEL_OPTION);
				if(yn==0)
				{
					System.exit(0);
				}
			}
		});
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		fillInfo();
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
			if(ob==exit)
			{	dispose();
		}
		else if(ob==update)
		{
			
			
			final String mobile=textmob.getText();

			if(mobile.trim().length()<10 )
			{
				JOptionPane.showMessageDialog(null, "Mobile no. < 10");
				return;
			}
			else if(mobile.trim().length()>10)
			{
				JOptionPane.showMessageDialog(null, "Mobile No. can not be greater than 10");
				return;
			}
			else
			{
				PhoneEx pe = new PhoneEx();
				   if(!pe.validate(textmob.getText().trim())) {
				        JOptionPane.showMessageDialog(null, "Mobile No. can not contains letters");
				       
				        return;
			}
			}
			final String desig=textdesig.getText();
			if(desig.length()==0)
			{
				JOptionPane.showMessageDialog(null, "Enter Designation");
				return;
			}
			final String mail=textmail.getText();
			if(mail.length()==0)
			{
				JOptionPane.showMessageDialog(null, "Fill E-mail");
				return;
			}
			else
			{
			EmailValid emailValidator = new EmailValid();
			   if(!emailValidator.validate(textmail.getText().trim())) {
			        JOptionPane.showMessageDialog(null, "Email is invalid");
			        
			        return;
			   }
			}
			user=textuser.getText();
			
			if(user.length()==0)
			{
				JOptionPane.showMessageDialog(null, "User name can not be null");
				return;
			}
			char pass[]=textpass.getPassword();
			final String pwd=String.copyValueOf(pass);
			if(pwd.length()==0)
			{
				JOptionPane.showMessageDialog(null, "Enter Password");
				return;
			}
			
			
			String s="Update details set cdesignation=?,cmobile=?,email=?,username=?,password=? where cid=? ";
			Connection con=MyConnection.getConnection();
			try
			{
				
				PreparedStatement ps=con.prepareStatement(s);
				
				ps.setString(1,desig);
				ps.setString(2,mobile);
				ps.setString(3,mail);
				ps.setString(4,user);
				ps.setString(5,pwd);
				ps.setInt(6, id);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null,"Updated");
				
				dispose();
				
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			
			
		}
		
	}	

	void fillInfo()
	{
		String s="Select * from details where cid=?";
		Connection c=MyConnection.getConnection();
		try
		{
			PreparedStatement ps=c.prepareStatement(s);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				textname.setText(rs.getString("cname"));
				
				if(rs.getString("cgender").equalsIgnoreCase("Male"))
				{
					male.setSelected(true);
				}
				else
				{
					female.setSelected(true);
				}
				textmob.setText(String.valueOf(rs.getInt("cmobile")));
				textdesig.setText(rs.getString("cdesignation"));
				textmail.setText(rs.getString("email"));
				textuser.setText(rs.getString("username"));
				textpass.setText(rs.getString("password"));

			}
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
			
}
	
}