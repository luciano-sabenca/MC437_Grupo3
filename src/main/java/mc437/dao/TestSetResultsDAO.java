package mc437.dao;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import mc437.bean.TestSetResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestSetResultsDAO {
	
	@Autowired
	DataSource datasource;
	
	public int save(TestSetResults testSetResults, int idItestResults){
		String sql = "SELECT MAX(id_seq) FROM test_set_results";
		
		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				"INSERT INTO test_set_results(cod"
				                           + ",path"
				                           + ",id"
				                           + ",id_i_test_result) VALUES (?, ?, ?,?)",
				new Object[] { testSetResults.getCod()
				              ,testSetResults.getPath()
					 	      ,testSetResults.getId()
					 	      ,idItestResults}
				              ,new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER });
		
		return template.queryForObject(sql, new Object[] {}, Integer.class);
	}
}
