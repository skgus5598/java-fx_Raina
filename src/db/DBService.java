package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemDTO;

public class DBService implements IDBService{

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public MemDTO chkId(String userId) {
		// select id from naver where id = ?;
		String sql = "select * from naver where id = ?";
		MemDTO d =  null;
		try {
			ps = DBCommon.conn.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			if(rs.next()) {
				d = new MemDTO();
				d.setId(rs.getString("id"));
				d.setPassword(rs.getString("pwd"));
				d.setfName(rs.getString("firstname"));
				d.setlName(rs.getString("lastname"));
				d.setGender(rs.getString("gender"));
			} else {					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	
	@Override
	public void insertMem(MemDTO dto) {
		String sql = "insert into naver values(?,?,?,?,?,?)";
		
		try {
			ps = DBCommon.conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getfName());
			ps.setString(4, dto.getlName());
			ps.setString(5, dto.getGender());
			ps.setString(6, dto.getEmail());
			
			ps.executeUpdate();
			System.out.println("디비에 저장 성공!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}










