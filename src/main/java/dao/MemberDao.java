package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import common.DBConnection;

public class MemberDao {

	public String loginCheck(String id, String password) {
		String userId = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from member where id=? and password=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userId = rs.getString("id");
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userId;
		}
		
	}
