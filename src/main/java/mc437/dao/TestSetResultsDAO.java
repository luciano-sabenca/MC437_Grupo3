package mc437.dao;

import java.util.List;

import mc437.bean.TestSetResults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestSetResultsDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(TestSetResults testSetResults, int idItestResults){
		String insert = "";
	}
}
