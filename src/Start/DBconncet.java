package Start;

import java.sql.*;
import java.util.Vector;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;


public class DBconncet {
 
    public static void connect() 
    {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:c:\\sqlite3\\db\\myDB.db";
            conn = DriverManager.getConnection(url);
            
            JOptionPane.showMessageDialog(null, "התחברת לבסיס הנתונים בהצלחה!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
            	JOptionPane.showMessageDialog(null, "DB failed");         
            	}
        }
    }

    
    public static DefaultTableModel buildTableModel(ResultSet rs)
    	    throws SQLException {

    	ResultSetMetaData metaData = rs.getMetaData();

    	// names of columns
    	Vector<String> columnNames = new Vector<String>();
    	int columnCount = metaData.getColumnCount();
    	for (int column = 1; column <= columnCount; column++) {
    	    columnNames.add(metaData.getColumnName(column));
    	}

    	// data of the table
    	Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    	while (rs.next()) {
    	    Vector<Object> vector = new Vector<Object>();
    	    for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
    	        vector.add(rs.getObject(columnIndex));
    	    }
    	    data.add(vector);
    	}

    	return new DefaultTableModel(data, columnNames);
    	
    	
    	
    	
    	// to print table using swing:
    	// JTable table = new JTable(DBconncet.buildTableModel(answer));
      //	JOptionPane.showMessageDialog(null, new JScrollPane(table));

    	}
   
}