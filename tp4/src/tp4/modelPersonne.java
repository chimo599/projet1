package tp4;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;



public class modelPersonne extends AbstractTableModel{

	
	
	ResultSetMetaData rsmd;
	
	
	ArrayList<Object[]> data_f=new ArrayList<Object[]>();
	
	
	
	public modelPersonne(ResultSet rs) {
		
		try {
		
			rsmd=rs.getMetaData();
			
			
			while(rs.next())
			{
				
				Object[] ligne =new Object[rsmd.getColumnCount()];
				
				for(int i=0;i<ligne.length;i++)
				{
					ligne [i]=rs.getObject(i+1);
				}
				
				data_f.add(ligne);
			}
		
		} catch (SQLException e) {
			System.out.println("erreur selection"+e.getMessage());
		}
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		try {
			
			return rsmd.getColumnCount();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return 0;
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data_f.size();
	}

	@Override
	public Object getValueAt(int l, int c) {
		// TODO Auto-generated method stub
		
			return (data_f.get(l))[c];
	}
	
	
	
	@Override
	public String getColumnName(int c) {
		// TODO Auto-generated method stub
		try {
			return rsmd.getColumnName(c+1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "erreur";
		}
	}

	
}


