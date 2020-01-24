package kr.or.connect.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;

public class RoleDao {
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Role> getRoles(){
		List<Role> list = new ArrayList<Role>();
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Connection conn = ac.getBean(Connection.class);
		
		String sql = "SELECT description, role_id FROM role order by role_id desc"; 
		
		//try-with-resource
		/*try (ps = conn.prepareStatement(sql)){
			
			try(rs = ps.executeQuery()){
				while(rs.next()) {
					Role role = new Role(rs.getInt("role_id"),rs.getString(1));
					
					list.add(role);
					
				}
			}catch(SQLException e) {
			
		}catch(SQLException e) {
			e.getStackTrace();
		}*/
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				Role role = new Role(rs.getInt("role_id"),rs.getString(1));
				list.add(role);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}
	public int addRole(Role role) { //Create : insert
		int insertCount=0;
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Connection conn = ac.getBean(Connection.class);
		
		try {
			String sql_insert = "INSERT INTO role (role_id, description) VALUES (?, ?)";
			
			ps = conn.prepareStatement(sql_insert);
			
			ps.setInt(1,  role.getRoleId());
			ps.setString(2, role.getDescription());
			
			insertCount = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return insertCount;
		
	}
	public Role getRole(Integer roleId) { // Read : select
		Role role = null;
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		Connection conn = ac.getBean(Connection.class);
		
		try {
			
			if(conn == null) //DB ����
				System.out.println("DB ���� ����");
			
			String sql = "SELECT description,role_id FROM web_master.role WHERE role_id = ?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				//ResultSetMetaData rmd = rs.getMetaData();	
				//System.out.println(rmd.getColumnName(2));
				String description = rs.getString(1);
				int id = rs.getInt("role_id");
				
				role = new Role(id, description);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return role;
	
	}

}
