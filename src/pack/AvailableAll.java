package pack;


import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class AvailableAll extends JDialog implements ActionListener{
	JButton book,close;
	String name;
	String avail;
	String st;
	int b;
	int no;
	public AvailableAll() {
//		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
//		setUndecorated(true);
		setForeground(Color.RED);
		
		getContentPane().setLayout(null);
		Container co=getContentPane();
		co.setBackground(Color.CYAN);
		
		
		
		setSize(700,700);
		
		
		
		String s="Select * from room";
		Connection con=MyConnection.getConnection();
		String columns[]={"Room No.","Room Type","Room Size","Room Fare","Room Available"};
		int cnt=0,r=0,c=0;
		
		try
		{
			PreparedStatement ps=con.prepareStatement(s);
			
			ResultSet rs=ps.executeQuery();
			rs.last();
			cnt=rs.getRow();
			rs.beforeFirst();
			String data[][]=new String[cnt][5];
			while(rs.next())
			{
				data[r][c]=String.valueOf(rs.getInt("RoomNo"));
				++c;
				data[r][c]=rs.getString("RoomType");
				++c;
				data[r][c]=rs.getString("RoomSize");
				++c;
				data[r][c]=String.valueOf(rs.getInt("RoomFare"));
				++c;
				data[r][c]=rs.getString("RoomAvail");
				++r;
				c=0;
				
			}
			JTable table=new JTable(data,columns);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JScrollPane jsp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jsp.setEnabled(false);
			jsp.setBounds(10,61,469,200);
			getContentPane().add(jsp);
			
			book = new JButton("Book");
			book.setBounds(412, 329, 89, 23);
			getContentPane().add(book);
			
//			 //close = new JButton("Close");
//			close.setBounds(198, 329, 89, 23);
			//getContentPane().add(close);
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
			book.addActionListener(this);
			//close.addActionListener(this);
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob=e.getSource();
//		if(ob==close)
//		{
//			int yn;
//			yn=JOptionPane.showConfirmDialog(null, "Sure to Exit", "Swings", JOptionPane.YES_NO_CANCEL_OPTION);
//			if(yn==0)
//			{
//				System.exit(0);
//		}
//		}
		 if(ob==book)
		{		st=JOptionPane.showInputDialog(null,"Enter Room No.","Message",1);
				b=Integer.parseInt(st);
				String s="Select * from room where Roomno=? and RoomAvail='NO'";
				Connection c=MyConnection.getConnection();
				boolean found=false;
				try{
					
					
					PreparedStatement ps=c.prepareStatement(s);
					ps.setInt(1,b);
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{	
						JOptionPane.showMessageDialog(null, "Room is Not Available");
					}
					else
					{
						found=true;
					}
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
			if(b>=101 && b<103 && found==true)
			{
				JOptionPane.showMessageDialog(null, "Room Found");
				new Book(b);
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Room Not Found");
//				new Book(b);	
				
			}
			
		}
		 
	}
	
	public static void main(String ar[])
	{	
		new AvailableAll();
	}
	
}