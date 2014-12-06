package mc437.dao;

import java.sql.Types;

import javax.sql.DataSource;

import mc437.bean.Transition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TransitionDAO {
	
	@Autowired
	DataSource datasource;
	
	public int save(Transition trans, int idState, int idMap, int idIMutants, int idITestResult){
		String sql = "SELECT MAX(id_seq) FROM transition";//?
		
		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				"INSERT INTO transition(id_iteste_result"
										   + ",id_imutant"
										   + ",id_map"
										   + ",id_state"
				                           + ",id"
				                           + ",is_mutant"
				                           + ",event) VALUES (?,?,?,?,?,?,?)",
				new Object[] { idITestResult
							   ,idIMutants
							   ,idMap
							   ,idState
				               ,trans.getId()
				               ,trans.getIsMutant()
				               ,trans.getEvent()}
				              ,new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.TINYINT, Types.VARCHAR});
		
		return template.queryForObject(sql, new Object[] {}, Integer.class);
	}
}
