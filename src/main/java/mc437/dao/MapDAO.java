package mc437.dao;

import java.sql.Types;

import javax.sql.DataSource;

import mc437.bean.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MapDAO {
	
	@Autowired
	DataSource datasource;
	
	public int save(Map map, int idIMutants, int idITestResult){
		String sql = "SELECT MAX(id_seq) FROM map";//?
		
		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				"INSERT INTO map(id_imutant"
										   + ",id_iteste_result"
				                           + ",id"
				                           + ",is_mutant"
				                           + ",name) VALUES (?,?,?,?,?)",
				new Object[] { idIMutants
							   ,idITestResult
				               ,map.getId()
				               ,map.getIsMutant()
				               ,map.getName()}
				              ,new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.TINYINT, Types.VARCHAR});
		
		return template.queryForObject(sql, new Object[] {}, Integer.class);
	}
}
