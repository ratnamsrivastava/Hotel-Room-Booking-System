package pack;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Process extends JFrame implements ActionListener {
	ImageIcon ii;
	JButton add, update,view,del,check,back;
	public Process() {
		getContentPane().setLayout(null);
		Container c=getContentPane();
		c.setBackground(Color.CYAN);
		ii=new ImageIcon("hd.gif");
		
		getContentPane().setLayout(null);
		
		 add = new JButton("Add Employee Details");
		add.setFont(new Font("Algerian", Font.PLAIN, 14));
		add.setBounds(442, 139, 220, 23);
		getContentPane().add(add);
		
		 update = new JButton("Update Employee Details");
		update.setFont(new Font("Algerian", Font.PLAIN, 14));
		update.setBounds(738, 139, 233, 23);
		getContentPane().add(update);
		
		view = new JButton("View Employee Details");
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		view.setFont(new Font("Algerian", Font.PLAIN, 14));
		view.setBounds(442, 203, 220, 23);
		getContentPane().add(view);
		
		 del = new JButton("Delete Employee Details");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		del.setFont(new Font("Algerian", Font.PLAIN, 14));
		del.setBounds(741, 203, 230, 23);
		getContentPane().add(del);
		
		back = new JButton("Back");
		back.setFont(new Font("Algerian", Font.PLAIN, 14));
		back.setBounds(635, 262, 135, 23);
		getContentPane().add(back);
		
		 check = new JButton("Check Availability of Room");
		check.setFont(new Font("Algerian", Font.PLAIN, 14));
		check.setBounds(555, 47, 273, 23);
		getContentPane().add(check);
		
		
		
		JLabel pic = new JLabel(ii);
		pic.setBounds(10, 11, 1342, 719);
		getContentPane().add(pic);
		setSize(getMaximumSize());
		back.addActionListener(this);
		add.addActionListener(this);
		del.addActionListener(this);
		view.addActionListener(this);
		update.addActionListener(this);
		check.addActionListener(this);
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
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Process();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==add)
		{
			new EmpAdd();
		}
		else if(ob==del)
		{
			delete();
		}
		else if(ob==view)
			
		{	
			String s="Select * from details";
			Connection con=MyConnection.getConnection();
				String st=JOptionPane.showInputDialog(null,"Enter id","Swings",1);
				
				int b=Integer.parseInt(st);
				boolean found=false;
				if(b<=3 )
			{
			JOptionPane.showMessageDialog(null,"Id Found");
			new ViewId(b);

}
else
{
			JOptionPane.showMessageDialog(null, "Id Not Found");
}
			}
		else if(ob==update)
		{

			String st=JOptionPane.showInputDialog(null,"Enter Id","Swings",1);
		
		int n=Integer.parseInt(st);
		new EmpUpdate(n);
		}

		else if(ob==check)
		{
			new Hotel();
			dispose();
		}
		else if(ob==back)
		{

			new Login();
			dispose();
			
		}
		
	}
	void delete()
	{
		String d=JOptionPane.showInputDialog(null,"Enter Id","Swings",1);
		int e=Integer.parseInt(d);
		int f=Integer.parseInt(d);
		String s="delete from details where cid=?";
		String st="delete from log where cid=?";
		Connection con=MyConnection.getConnection();
		try
		{
			PreparedStatement ps=con.prepareStatement(s);
			PreparedStatement pss=con.prepareStatement(st);
			ps.setInt(1,e);
			pss.setInt(1,f);
			int n=pss.executeUpdate();
			int m=ps.executeUpdate();
			if(m>0 && n>0)
			{
				JOptionPane.showMessageDialog(null, "Deleted");
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Id not found");
				
			}
			
		}
	catch (SQLException se)
	{
		se.printStackTrace();
	}
}
}
