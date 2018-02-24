package cn.jdbc.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest01 {
	public static void main(String[] args) {
		String url ="jdbc:mysql://192.168.73.166:3306:emo01";
		String user = "root";
		String password = "123";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//���ݿ���������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			con = DriverManager.getConnection(url,user,password);
			//����sql���
			pstmt = con.prepareStatement("select * from student");
			//ִ��Ԥ�������
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("sno")+","+rs.getString("sname")+","+rs.getString("ssex")+","+rs.getString("class")+","+rs.getDate("sbirthday"));
			}
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
