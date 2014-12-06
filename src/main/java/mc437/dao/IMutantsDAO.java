package mc437.dao;

import java.sql.Types;

import javax.sql.DataSource;

import mc437.bean.IMutants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class IMutantsDAO {
	
	@Autowired
	DataSource datasource;
	
	public int save(IMutants iMutants, int idItestResults){
		String sql = "SELECT MAX(id_seq) FROM imutants";//?
		
		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				"INSERT INTO imutants(id_iteste_result"
				                           + ",id"
				                           + ",build_flag"
				                           + ",context_id"
				                           + ",conv_flag"
				                           + ",ignore_errors"
				                           + ",is_mutant"
				                           + ",initial_state"
				                           + ",name"
				                           + ",path) VALUES (?,?,?,?,?,?,?,?,?,?)",
				new Object[] { idItestResults
				               ,iMutants.getId()
				               ,iMutants.getBuildFlag()
				               ,iMutants.getContextId()
				               ,iMutants.getConvFlag()
				               ,iMutants.getIgnoreErros()
				               ,iMutants.getIsMutant()
				               ,iMutants.getInitialState()
				               ,iMutants.getName()
				               ,iMutants.getPath()}
				              ,new int[] { Types.INTEGER, Types.INTEGER, Types.TINYINT, Types.VARCHAR, Types.TINYINT, Types.TINYINT, Types.TINYINT, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR});
		
		return template.queryForObject(sql, new Object[] {}, Integer.class);
	}
}
