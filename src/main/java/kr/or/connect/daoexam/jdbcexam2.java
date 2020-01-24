package kr.or.connect.daoexam;

import java.util.ArrayList;
import java.util.List;

import kr.or.connect.dto.*;

public class jdbcexam2 {
	
	public static void main(String[] args) {
		List<Role> role_list = new ArrayList<Role>();
		
		RoleDao dao = new RoleDao();
		
		role_list = dao.getRoles();
		
		for(Role x : role_list)
			System.out.println(x);
		
	}
}
