package cn.jdbc.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTest02 {
	public static void main(String[] args) {
		String url ="jdbc:mysql://192.168.73.166:3306/Demo02?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "123";
		Connection con = null;
		PreparedStatement pstm = null;
		int  updt = 0;
		
		try {
			//���ݿ��������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			con = DriverManager.getConnection(url,user,password);
			//����sql���
			pstm = con.prepareStatement("insert into student(name,b_id) values(?,?)");
			//ע��sql���
			pstm.setString(1,"Ц");
			pstm.setInt(2, 2);
			
			 updt = pstm.executeUpdate();
			
			System.out.println(updt);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(pstm!=null)
					pstm.close();
				if(con!=null){
					con.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
