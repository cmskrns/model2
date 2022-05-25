package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DBConnection;
import dto.Product;

public class ProductRepository {
	
	public List<Product> findAll(){
		List<Product> productList = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from product";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product product = new Product(
						rs.getString("p_id"),
						rs.getString("p_name"),
						rs.getInt("p_unitPrice"),
						rs.getString("p_description"),
						rs.getString("p_category"),
						rs.getString("p_manufacturer"),
						rs.getLong("p_unitsInStock"),
						rs.getString("p_condition"),
						rs.getString("p_fileName")
						);
				productList.add(product);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt!=null) {try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
		}
		
		return productList;
	}

	public Product findById(String id) {
		Product product = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from product where p_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				product = new Product(
						rs.getString("p_id"),
						rs.getString("p_name"),
						rs.getInt("p_unitPrice"),
						rs.getString("p_description"),
						rs.getString("p_category"),
						rs.getString("p_manufacturer"),
						rs.getLong("p_unitsInStock"),
						rs.getString("p_condition"),
						rs.getString("p_fileName")
						);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
			if(pstmt!=null) {try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null) {try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
		}
		
		return product;
	}
	
	public void insert(Product product) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into product(p_id,p_name,p_unitPrice,p_description,p_category,p_manufacturer,p_unitsInStock,p_condition,p_fileName) values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getProductId());
			pstmt.setString(2, product.getPname());
			pstmt.setInt(3, product.getUnitprice());
			pstmt.setString(4, product.getDescription());
			pstmt.setString(5, product.getCategory());
			pstmt.setString(6, product.getManufacturer());
			pstmt.setLong(7, product.getUnitsInStock());
			pstmt.setString(8, product.getCondition());
			pstmt.setString(9, product.getFilename());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null){try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
			if(conn!=null){try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
		}
	}

}
