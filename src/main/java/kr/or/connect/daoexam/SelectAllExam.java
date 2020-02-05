package kr.or.connect.daoexam;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.daoexam.config.ApplicationConfig;
import kr.or.connect.dto.Role;
import kr.or.connect.dto.RoleDao2;

public class SelectAllExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class); 
		
		RoleDao2 roleDao =ac.getBean(RoleDao2.class);
		
		List<Role> allList = roleDao.selectAll();
		
		for(Role role : allList)
			System.out.println(role);
		
		Role makeRole = new Role();
		makeRole.setRoleId(155);
		makeRole.setDescription("");
		
		/*int insert = roleDao.insert(makeRole);
		System.out.println(insert+"이 삽입되었습니다");
		
		allList = roleDao.selectAll();
		
		for(Role role : allList)
			System.out.println(role);

		makeRole.setDescription("선희");
		
		int update = roleDao.update(makeRole);
		System.out.println(update+"이 갱신되었습니다");
		
		allList = roleDao.selectAll();
		
		for(Role role : allList)
			System.out.println(role);*/
		
		int delete = roleDao.deleteById(151);
		System.out.println(delete+"이 삭제되었습니다");
		
		allList = roleDao.selectAll();
		
		for(Role role : allList)
			System.out.println(role);
		
		
		allList = roleDao.selectById(501);
		
		for(Role role : allList)
			System.out.println(role);
	}

}
