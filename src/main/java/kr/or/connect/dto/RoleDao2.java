package kr.or.connect.dto;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import static kr.or.connect.dto.RoleDaoSqls.*;

@Repository
public class RoleDao2 {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);
	
	public RoleDao2(DataSource datasource) {
		this.jdbc = new NamedParameterJdbcTemplate(datasource);
		this.insertAction = new SimpleJdbcInsert(datasource)
				.withTableName("role");
	}
	
	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(),rowMapper);
	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return insertAction.execute(params);
		
	}
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE,params);
	}
	public int deleteById(int id) {
		Map<String, ?> params = Collections.singletonMap("roleId",id);
		return jdbc.update(DELETE_BY_ROLE_ID,params);
	}
	public List<Role> selectById(int id) {
		Map<String, ?> params= Collections.singletonMap("roleId",id);
		try {
			return jdbc.query(SELECT_BY_ROLE_ID,params,rowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
