package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;



public class Book extends JDialog implements ActionListener,ItemListener{
	//int id;
	JButton cancel,submit,cal,back;
	private JTextField textname;
	
	private JTextField textmobile;
	private JTextField textmail;
	private JTextField textField;
	private JLabel pic;
	ImageIcon ii,oo,hh,pp,tt;
	private JTextField address;
	JRadioButton m,f;
	private JTextField day;
	private JTextField mem;
	private JTextField textfare;
	private JTextField totalfare;
	private JTextField roomno;
	int no;
	String string;

	JComboBox com;
	private JTextField timedate;
	private JLabel lblDateAndTime;
	public Book(int no) {

		this.no=no;
		getContentPane().setLayout(null);
		Container c=getContentPane();
		c.setBackground(Color.yellow);
		ii=new ImageIcon("Executivesuite.gif");
		hh=new ImageIcon("add.gif");
		oo=new ImageIcon("close.gif");
		pp=new ImageIcon("back.gif");
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Tahoma", Font.BOLD, 14));
		gender.setBounds(21, 91, 66, 14);
		getContentPane().add(gender);
		
		 submit = new JButton("Add",hh);
		// submit.setIcon(new ImageIcon("C:\\Users\\abc\\Desktop\\JavaProj\\Project\\add.GIF"));
		 submit.setFont(new Font("Tahoma", Font.BOLD, 11));
		 
		 submit.setHorizontalAlignment(SwingConstants.RIGHT);
		submit.setBounds(365, 553, 89, 23);
		getContentPane().add(submit);
		
		 cancel = new JButton("Cancel",oo);
		 
		 cancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		 
		cancel.setBounds(21, 553, 122, 23);
		getContentPane().add(cancel);
		
		JLabel desig = new JLabel("Address:");
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
		textname.setBounds(152, 41, 246, 23);
		getContentPane().add(textname);
		textname.setColumns(10);
		
		
		JLabel lblMobileNo = new JLabel("Mobile no.:");
		lblMobileNo.setIcon(new ImageIcon("C:\\Users\\abc\\Desktop\\JavaProj\\Project\\mob.GIF"));
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobileNo.setBounds(21, 175, 109, 26);
		getContentPane().add(lblMobileNo);
		
		textmobile = new JTextField();
		textmobile.setForeground(Color.MAGENTA);
		textmobile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textmobile.setBounds(152, 181, 246, 20);
		getContentPane().add(textmobile);
		textmobile.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(21, 224, 66, 14);
		getContentPane().add(lblEmail);
		
		textmail = new JTextField();
		textmail.setForeground(SystemColor.desktop);
		textmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textmail.setBounds(152, 221, 246, 20);
		getContentPane().add(textmail);
		textmail.setColumns(10);
		
		pic = new JLabel(ii);
		pic.setBounds(403, 164, 271, 215);
		getContentPane().add(pic);
		
		address = new JTextField();
		address.setBounds(152, 144, 246, 20);
		getContentPane().add(address);
		address.setColumns(10);
		
		f = new JRadioButton("Female");
		f.setForeground(Color.RED);
		f.setFont(new Font("Tahoma", Font.BOLD, 14));
		f.setBounds(307, 89, 89, 23);
		getContentPane().add(f);
		
		m = new JRadioButton("Male");
		m.setFont(new Font("Tahoma", Font.BOLD, 14));
		m.setForeground(Color.BLUE);
		m.setBounds(152, 87, 82, 23);
		getContentPane().add(m);
		ButtonGroup bg=new ButtonGroup();
		bg.add(m);
		bg.add(f);
		
		
		JLabel lblNoOfDays = new JLabel("No. Of Days:");
		lblNoOfDays.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNoOfDays.setBounds(21, 267, 89, 14);
		getContentPane().add(lblNoOfDays);
		
		day = new JTextField();
		day.setBounds(152, 266, 79, 20);
		getContentPane().add(day);
		day.setColumns(10);
		
		JLabel lblNoOfMembers = new JLabel("No. Of Members:");
		lblNoOfMembers.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNoOfMembers.setBounds(21, 313, 122, 14);
		getContentPane().add(lblNoOfMembers);
		
		mem = new JTextField();
		mem.setColumns(10);
		mem.setBounds(152, 312, 79, 20);
		getContentPane().add(mem);
		
		JLabel lblFare = new JLabel("Fare Per Day:");
		lblFare.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFare.setBounds(21, 353, 122, 19);
		getContentPane().add(lblFare);
		
		textfare = new JTextField();
		textfare.setEditable(false);
		textfare.setFont(new Font("Tahoma", Font.BOLD, 14));
		textfare.setForeground(Color.RED);
		textfare.setBounds(152, 352, 137, 20);
		getContentPane().add(textfare);
		textfare.setColumns(10);
		
		cal = new JButton("Calculate Fare");
		cal.setBounds(323, 440, 122, 34);
		getContentPane().add(cal);
		
		totalfare = new JTextField();
		totalfare.setEditable(false);
		totalfare.setFont(new Font("Tahoma", Font.BOLD, 16));
		totalfare.setForeground(Color.RED);
		totalfare.setColumns(10);
		totalfare.setBounds(21, 438, 268, 34);
		getContentPane().add(totalfare);
		
		JLabel lblRoom = new JLabel("Room No:");
		lblRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRoom.setBounds(21, 11, 82, 14);
		getContentPane().add(lblRoom);
		
		roomno = new JTextField();
		roomno.setEditable(false);
		roomno.setFont(new Font("Tahoma", Font.BOLD, 14));
		roomno.setForeground(Color.RED);
		roomno.setBounds(152, 10, 89, 20);
		getContentPane().add(roomno);
		roomno.setColumns(10);
		
		 back = new JButton("Back",pp);
		back.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		back.setBounds(192, 553, 97, 23);
		getContentPane().add(back);
		
		timedate = new JTextField();
		timedate.setFont(new Font("Tahoma", Font.BOLD, 16));
		timedate.setForeground(Color.RED);
		timedate.setEditable(false);
		timedate.setBounds(152, 390, 396, 23);
		getContentPane().add(timedate);
		timedate.setColumns(10);
		
		lblDateAndTime = new JLabel("Day,Date & Time:");
		lblDateAndTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateAndTime.setBounds(21, 393, 122, 14);
		getContentPane().add(lblDateAndTime);
		

		setSize(700,700);
		submit.addActionListener(this);
		cancel.addActionListener(this);
		cal.addActionListener(this);
		back.addActionListener(this);
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
		book();
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==cancel)
		{
			int yn;
			yn=JOptionPane.showConfirmDialog(null, "Sure to Exit", "Swings", JOptionPane.YES_NO_CANCEL_OPTION);
			if(yn==0)
			{
				System.exit(0);
			dispose();
		}
		}
			else if(ob==back)
			{
				new AvailableAll();
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
			String add=address.getText();
			if(add.length()==0)
			{
				JOptionPane.showMessageDialog(null, "Address is invalid");
				return;
			}
			 String gender="";
			 
			 if(m.isSelected())
			{
				gender="Male";
				
			}
			else
				gender="Female";
			
			final String mobile=textmobile.getText();
			
			
			if(mobile.length()==0)
			{
				JOptionPane.showMessageDialog(null, "Enter Mobile No.");
				return;
			}
			
			else if(mobile.trim().length()<10 )
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
				   if(!pe.validate(textmobile.getText().trim())) {
				        JOptionPane.showMessageDialog(null, "Mobile No. can not contains letters");
				       
				        return;
			}
			}
			
			final String email=textmail.getText();
			if(email.length()==0)
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

			int days=Integer.parseInt(day.getText());
			if(days==0)
			{
				JOptionPane.showMessageDialog(null, "Enter no. of days");
				return;
			}
			
			int memb=Integer.parseInt(mem.getText());
			if(memb==0)
			{
				JOptionPane.showMessageDialog(null,"Enter Member");
				return;
			}
			else if(memb>4)
				{
					JOptionPane.showMessageDialog(null, "Maximum 4 Members are allowed in one room");
					return;
				}
			
			
			int farePer=Integer.parseInt(textfare.getText());
			String total=totalfare.getText();
			int room=Integer.parseInt(roomno.getText());
			String daa=timedate.getText();
			String s="Insert into add_details (Name,Gender,Address,Mobile,Mail,Days,Members,FarePerDay,TotalFare,RoomNo,DateAndTime) values(?,?,?,?,?,?,?,?,?,?,?)";
			try
			{
				Connection con=MyConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(s);
				ps.setString(3,add);
				ps.setString(4,mobile);
				ps.setString(5,email);
				
				ps.setString(1,name);
				ps.setString(2,gender);
				ps.setInt(6,days);
				ps.setInt(7, memb);
				ps.setInt(8, farePer);
				ps.setString(9, total);
				ps.setInt(10, room);
				ps.setString(11, daa);
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null,"Room Booked ","Message", 1);
				
				dispose();
				
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
		}
		else if(ob==cal)
		{
			
			int fare,days;
			try
			{
				days=Integer.parseInt(day.getText());
			}
			catch(Exception se)
			{
			return;
			}
			try
			{
			fare=Integer.parseInt(textfare.getText());
			}
			catch(Exception se)
			{
			return;
			}
			int tot;
			if(days<15)
			{
				Date d=new Date();
				DateFormat fmt= DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.UK);
				string=fmt.format(d);
				//int da=Integer.parseInt(str.getText());
				timedate.setText("" +string);
				//System.out.println("IN UK:" +"\t" +string);
			tot=(days*fare);
			totalfare.setText("Total Fare= " +tot +"Rs.");
			}
			else if(days>15)
			{
				JOptionPane.showMessageDialog(null, "You can book room for maximum 15 days");
				return;
			}

		}
		}

	void book()
	{
		
		String s="Select * from room where RoomNo=?";
		Connection c=MyConnection.getConnection();
		try
		{
			PreparedStatement ps=c.prepareStatement(s);
			ps.setInt(1,no);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				roomno.setText(String.valueOf(rs.getInt("RoomNo")));
				textfare.setText(String.valueOf(rs.getInt("RoomFare")));
			}
}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}

