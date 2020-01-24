package kr.or.connect.daoexam;

import kr.or.connect.dto.Role;
import kr.or.connect.dto.RoleDao;

public class jdbcexam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}

}
