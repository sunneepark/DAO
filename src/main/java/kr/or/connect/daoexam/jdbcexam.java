package kr.or.connect.daoexam;

import kr.or.connect.dto.*;
public class jdbcexam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int roleId = 501;
		String description ="CTO";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		
		int insertCount = dao.addRole(role);
		System.out.println(insertCount);
	}

}
