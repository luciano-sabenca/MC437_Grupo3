package mc437.dao;

import java.sql.Types;

import javax.sql.DataSource;

import mc437.bean.State;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StateDAO {
	
	@Autowired
	DataSource datasource;
	
	public int save(State state /*, int idMap, int idIMutants, int idITestResult*/){
		String sql = "SELECT MAX(id_seq) FROM state";//?
		
		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				"INSERT INTO state(id_iteste_result"
										   + ",id_imutant"
										   + ",id_map"
				                           + ",id"
				                           + ",is_mutant"
				                           + ",name) VALUES (?,?,?,?,?,?)",
				new Object[] { state.getIdITestResult()
							   ,state.getIdIMutant()
							   ,state.getIdMap()
				               ,state.getId()
				               ,state.getIsMutant()
				               ,state.getName()}
				              ,new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.TINYINT, Types.VARCHAR});
		
		return template.queryForObject(sql, new Object[] {}, Integer.class);
	}
}
