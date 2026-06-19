package Pack2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Pack1.DBConnect;
import Pack1.ProductBean;

public class UpdateProductServletDAO 
{
	
	public int UpdateCusProductDetails(String ProductId,String Quantity)
	{
		int rowCount=0;
		
		try
		
		{
			Connection con=DBConnect.getCon();
			PreparedStatement pstm=con.prepareStatement("update product set pqty=pqty-? where pcode=? and pqty>=?");
			pstm.setInt(1, Integer.parseInt(Quantity));
			pstm.setString(2, ProductId);
			pstm.setInt(3, Integer.parseInt(Quantity));
			rowCount=pstm.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}
}