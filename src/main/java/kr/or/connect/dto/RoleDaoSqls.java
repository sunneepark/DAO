package kr.or.connect.dto;

public class RoleDaoSqls {
	public static final String SELECT_ALL="select * from role order by role_id";
	public static final String UPDATE = "update role SET description = :description where role_id = :roleId";
	public static final String DELETE_BY_ROLE_ID = "delete from role where role_id = :roleId";
	public static final String SELECT_BY_ROLE_ID="select * from role where role_id = :roleId order by role_id";
	
}
