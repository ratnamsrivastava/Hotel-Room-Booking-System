package pack;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewId extends JDialog{
	public ViewId(int id) {
		getContentPane().setLayout(null);
		setSize(700,700);
		
		// TODO Auto-generated constructor stub
		
		String s="Select * from details where cid=?";
		Connection con=MyConnection.getConnection();
		String columns[]={"Id","Name","Gender","Designation","Mobile","Email"};
		int cnt=0,r=0,c=0;
		
		try
		{
			PreparedStatement ps=con.prepareStatement(s);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			rs.last();
			cnt=rs.getRow();
			rs.beforeFirst();
			String data[][]=new String[cnt][8];
			while(rs.next())
			{
				data[r][c]=String.valueOf(rs.getInt("cid"));
				++c;
				data[r][c]=rs.getString("cname");
				++c;
				data[r][c]=rs.getString("cgender");
				++c;
				data[r][c]=rs.getString("cdesignation");
				++c;
				data[r][c]=String.valueOf(rs.getInt("cmobile"));
				++c;
				data[r][c]=rs.getString("email");
				++c;
//				data[r][c]=rs.getString("username");
//				++c;
//				data[r][c]=rs.getString("password");
				++r;
				c=0;
				
				
			}
			JTable table=new JTable(data,columns);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			JScrollPane jsp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jsp.setBounds(10,61,469,200);
			getContentPane().add(jsp);
			
			setVisible(true);
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
		
	}

