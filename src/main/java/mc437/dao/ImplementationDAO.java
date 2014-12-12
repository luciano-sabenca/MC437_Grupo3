package mc437.dao;

import java.sql.Types;

import javax.sql.DataSource;

import mc437.bean.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ImplementationDAO {
	
	@Autowired
	DataSource datasource;
	
	public int save(Implementation impl, int idIMutants, int idITestResult){
		String sql = "SELECT MAX(id_seq) FROM implementation";//?
		
		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				"INSERT INTO implementation(id_imutant"
										   + ",id_iteste_result"
				                           + ",id"
				                           + ",type"
				                           + ",is_mutant"
				                           + ",content) VALUES (?,?,?,?,?,?)",
				new Object[] { idIMutants
							   ,idITestResult
				               ,impl.getId()
				               ,impl.getType()
				               ,impl.getIsMutant()
				               ,impl.getContent()}
				              ,new int[] { Types.INTEGER, Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.TINYINT, Types.LONGNVARCHAR});
		
		return template.queryForObject(sql, new Object[] {}, Integer.class);
	}
}
