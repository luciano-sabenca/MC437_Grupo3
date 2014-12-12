package mc437.dao;

import java.sql.Types;

import javax.sql.DataSource;

import mc437.bean.Guard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GuardDAO {
	
	@Autowired
	DataSource datasource;
	
	public int save(Guard grd, int idTrans, int idState, int idMap, int idIMutants, int idITestResult){
		String sql = "SELECT MAX(id_seq) FROM guard";//?
		
		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				"INSERT INTO guard(id_iteste_result"
										   + ",id_imutant"
										   + ",id_map"
										   + ",id_state"
										   + ",id_transition"
				                           + ",id"
				                           + ",is_mutant"
				                           + ",clone_global_index_transition_index"
				                           + ",guard_condition"
				                           + ",global_index"
				                           + ",pop_args"
				                           + ",push_state"
				                           + ",target_state"
				                           + ",transition_type"
				                           + ",t_index) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[] { idITestResult
							   ,idIMutants
							   ,idMap
							   ,idState
							   ,idTrans
				               ,grd.getId()
				               ,grd.getIsMutant()
				               ,grd.getCloneGlobalIndexTransitionIndex()
				               ,grd.getGuardCondition()
				               ,grd.getGlobalIndex()
				               ,grd.getPopArgs()
				               ,grd.getPushState()
				               ,grd.getTargetState()
				               ,grd.getTransitionType()
				               ,grd.gettIndex()}
				              ,new int[] { Types.INTEGER
									      ,Types.INTEGER
									      ,Types.INTEGER
									      ,Types.INTEGER
									      ,Types.INTEGER
									      ,Types.VARCHAR //id
									      ,Types.BOOLEAN //is_mutant
									      ,Types.TINYINT
									      ,Types.VARCHAR //guard_condition
									      ,Types.VARCHAR //global_index
									      ,Types.VARCHAR //pop_args
									      ,Types.VARCHAR //push_state
									      ,Types.VARCHAR //target_state
									      ,Types.VARCHAR //transition_type
									      ,Types.VARCHAR //t_index
									      });
		
		return template.queryForObject(sql, new Object[] {}, Integer.class);
	}
}
