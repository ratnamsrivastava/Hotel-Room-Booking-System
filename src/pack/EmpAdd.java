package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;



public class EmpAdd extends JDialog implements ActionListener{
	private JTextField txtcid;
	JRadioButton m,f;
	int id;
	JButton cancel,submit;
	private JTextField textname;
	private JTextField textdesig;
	private JTextField textmobile;
	private JTextField textmail;
	private JTextField textField;
	private JPasswordField textpass;
	private JTextField textuser;
	String mobile;
	private JTextField textques;
	private JPasswordField textans;
	private JLabel lblNewLabel_1;
	//String user;
	
	public EmpAdd() {
	
		getContentPane().setLayout(null);
		Container c=getContentPane();
		c.setBackground(Color.GREEN);
		
		JLabel name = new JLabel("Id:");
		name.setFont(new Font("Tahoma", Font.BOLD, 14));
		name.setBounds(21, 11, 46, 14);
		getContentPane().add(name);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Tahoma", Font.BOLD, 14));
		gender.setBounds(21, 91, 66, 14);
		getContentPane().add(gender);
		
		 m = new JRadioButton("Male");
		 m.setForeground(Color.BLUE);
		 m.setFont(new Font("Tahoma", Font.BOLD, 14));
		 
		m.setBounds(149, 87, 109, 23);
		
		getContentPane().add(m);
		
		 f = new JRadioButton("Female");
		 f.setForeground(new Color(199, 21, 133));
		 f.setFont(new Font("Tahoma", Font.BOLD, 14));
		f.setBounds(279, 87, 109, 23);
		getContentPane().add(f);
		
		 submit = new JButton("Submit");
		 submit.setFont(new Font("Tahoma", Font.BOLD, 14));
		submit.setBounds(229, 486, 89, 23);
		getContentPane().add(submit);
		
		txtcid = new JTextField();
		txtcid.setForeground(Color.RED);
		txtcid.setEditable(false);
		txtcid.setBounds(149, 10, 144, 20);
		getContentPane().add(txtcid);
		txtcid.setColumns(10);
		ButtonGroup bg=new ButtonGroup();
		bg.add(f);
		bg.add(m);
		
		 cancel = new JButton("Cancel");
		 cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancel.setBounds(21, 486, 89, 23);
		getContentPane().add(cancel);
		
		JLabel desig = new JLabel("Designation:");
		desig.setFont(new Font("Tahoma", Font.BOLD, 14));
		desig.setBounds(21, 141, 99, 23);
		getContentPane().add(desig);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(21, 49, 46, 14);
		getContentPane().add(lblName);
		
		textname = new JTextField();
		textname.setForeground(Color.RED);
		textname.setFont(new Font("Alaska", Font.BOLD, 15));
		textname.setBounds(149, 45, 227, 23);
		getContentPane().add(textname);
		textname.setColumns(10);
		
		textdesig = new JTextField();
		textdesig.setForeground(Color.BLACK);
		textdesig.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textdesig.setBounds(149, 142, 166, 20);
		getContentPane().add(textdesig);
		textdesig.setColumns(10);
		
		JLabel lblMobileNo = new JLabel("Mobile no.:");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNo.setBounds(21, 186, 82, 14);
		getContentPane().add(lblMobileNo);
		
		textmobile = new JTextField();
		textmobile.setForeground(Color.BLACK);
		textmobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textmobile.setBounds(149, 183, 166, 20);
		getContentPane().add(textmobile);
		textmobile.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(21, 224, 66, 14);
		getContentPane().add(lblEmail);
		
		textmail = new JTextField();
		textmail.setForeground(SystemColor.desktop);
		textmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textmail.setBounds(149, 221, 166, 20);
		getContentPane().add(textmail);
		textmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(21, 268, 89, 23);
		getContentPane().add(lblNewLabel);
		
		textuser = new JTextField();
		textuser.setBounds(149, 271, 160, 20);
		getContentPane().add(textuser);
		textuser.setColumns(10);
		
		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblpassword.setBounds(21, 318, 82, 14);
		
		getContentPane().add(lblpassword);
		
		textpass = new JPasswordField();
		textpass.setForeground(new Color(0, 128, 128));		textpass.setBounds(149, 315, 178, 25);
		getContentPane().add(textpass);
		
		JLabel lblQues = new JLabel("Question:");
		lblQues.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQues.setBounds(21, 392, 82, 14);
		getContentPane().add(lblQues);
		
		textques = new JTextField();
		textques.setBounds(167, 391, 249, 20);
		getContentPane().add(textques);
		textques.setColumns(10);
		
		JLabel lblAns = new JLabel("Answer:");
		lblAns.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAns.setBounds(21, 441, 66, 14);
		getContentPane().add(lblAns);
		
		textans = new JPasswordField();
		textans.setBounds(167, 438, 249, 20);
		getContentPane().add(textans);
		
		lblNewLabel_1 = new JLabel("Generate A Question and Give Its Answer (for SECURITY PURPOSE)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(119, 351, 503, 23);
		getContentPane().add(lblNewLabel_1);
		setSize(700,700);
		submit.addActionListener(this);
		cancel.addActionListener(this);
		getId();
		
		

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new EmpAdd();
			//e.setModal(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==cancel)
		{
			dispose();
		}
		else if(ob==submit)
		{
			String name=textname.getText();
			if(name.length()==0)
			{
				JOptionPane.showMessageDialog(null, "Fill Name");
				return;
			}
			final String desig=textdesig.getText();
			if(desig.length()==0)
			{
				JOptionPane.showMessageDialog(null, "Enter Designation");
				return;
			}
			String gender="";
			if(m.isSelected())
			{
				gender="Male";
				
			}
			else
				gender="Female";
			 mobile=textmobile.getText();
			 if(mobile.length()==0)
			 {
				 JOptionPane.showMessageDialog(null, "Enter Mobile Number");
				 return;
			 }

			 else if(mobile.trim().length()<10 )
			{
				JOptionPane.showMessageDialog(null, "Mobile no. can not be less than 10");
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
				   if(!pe.validate(textmobile.getText().trim())) {
				        JOptionPane.showMessageDialog(null, "Mobile No. can not contains letters");
				       
				        return;
			}
			}
		
			 String email=textmail.getText();
			if(email.length()==0)
			{
				JOptionPane.showMessageDialog(null, "Enter Your E-mail");
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

			final String user=textuser.getText();
			
			if(user.length()==0)
			{
				JOptionPane.showMessageDialog(null, "User name can not be null");
				return;
			}
			char[] pass=textpass.getPassword();
			final String pwd=String.copyValueOf(pass);
			if(pwd.length()==0)
			{
				JOptionPane.showMessageDialog(null, "Enter Password");
				return;
			}
			String s="Insert into details (cid,cname,cgender,cdesignation,cmobile,email,username,password) values(?,?,?,?,?,?,?,?)";
			try
			{
				Connection con=MyConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(s);
				ps.setInt(1,id);
				ps.setString(4,desig);
				ps.setString(5,mobile);
				ps.setString(6, email);
				ps.setString(2, name);
				ps.setString(3,gender);
				ps.setString(7,user);
				ps.setString(8, pwd);
				
				ps.executeUpdate();
				
				
				String na=textname.getText();
				String q=textques.getText();
				if(q.length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter Question");
					return;
				}
				
				
				char pass1[]=textpass.getPassword();
				String pwd1=String.copyValueOf(pass1);
				char pa[]=textans.getPassword();
				String ans=String.copyValueOf(pa);
				if(ans.length()==0)
				{
					JOptionPane.showMessageDialog(null, "Enter Answer");
					return;
				}
				String s1="Insert into log(cid,User_Name,Password,question,answer) values(?,?,?,?,?)";
				
				try
				{
					
					Connection con1=MyConnection.getConnection();
					PreparedStatement ps1=con1.prepareStatement(s1);
					ps1.setInt(1, id);
					ps1.setString(2, na);
					ps1.setString(3, pwd1);
					ps1.setString(4, q);
					ps1.setString(5, ans);
					ps1.executeUpdate();
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				JOptionPane.showMessageDialog(null,"Information Added","Message", 1);
				int yn;
				yn=JOptionPane.showConfirmDialog(null, "Want to add more employee?? ", "Add", JOptionPane.YES_NO_OPTION);
				if(yn==0)
				{
					new EmpAdd();
				}
				
			}
				
		catch (SQLException se)
		{
			se.printStackTrace();
		}
		}
			
		dispose();	
			}
			
			
	


	void getId()
	{
		String s="Select max(cid) from details";
		Connection con=MyConnection.getConnection();
		
		try
		{	
			PreparedStatement ps=con.prepareStatement(s);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
				
			}
			
		}
	catch (SQLException se)
	{
		se.printStackTrace();
	}
	++id;
	txtcid.setText(String.valueOf(id));
}
}
