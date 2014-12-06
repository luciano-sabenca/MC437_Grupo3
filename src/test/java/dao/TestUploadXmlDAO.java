package dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class TestUploadXmlDAO extends TestBaseDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public int getMaxIdTestResult(){
		String sql = "SELECT MAX(id) FROM I_Test_Result";
		
		jdbcTemplate = new JdbcTemplate(getConnectionDataSource());
		int maxId = jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);
		
		return maxId;
	}
	
	public Boolean checkFileParsed(int id){
		Integer exists = 0;
		String sql = "SELECT 1 FROM I_Test_Result WHERE id = ?";
		
		jdbcTemplate = new JdbcTemplate(getConnectionDataSource());
		exists = jdbcTemplate.queryForObject(sql, new Object[] {id}, Integer.class);
		
		return exists == 1;
	}
	
	public Boolean checkFileParsedTestSetResults(int idITestResult){
		Integer exists = 0;
		String sql = "SELECT DISTINCT 1 FROM test_set_results WHERE id_i_test_result = ?";
		
		jdbcTemplate = new JdbcTemplate(getConnectionDataSource());
		exists = jdbcTemplate.queryForObject(sql, new Object[] {idITestResult}, Integer.class);
		
		return exists == 1;
	}
	
	public Boolean checkFileParsedTestCaseResults(int idITestResult){
		Integer exists = 0;
		String sql = "SELECT DISTINCT 1 FROM test_case_results WHERE  id_i_test_results = ?";
		
		jdbcTemplate = new JdbcTemplate(getConnectionDataSource());
		exists = jdbcTemplate.queryForObject(sql, new Object[] {idITestResult}, Integer.class);
		
		return exists == 1;
	}
	
	public Boolean checkFileParsedTestCaseExecutingOutputMutantList(int idITestResult){
		Integer exists = 0;
		String sql = "SELECT DISTINCT 1 FROM test_case_executing_output_mutantlist WHERE  id_i_test_results = ?";
		
		jdbcTemplate = new JdbcTemplate(getConnectionDataSource());
		exists = jdbcTemplate.queryForObject(sql, new Object[] {idITestResult}, Integer.class);
		
		return exists == 1;
	}
	
	public Boolean checkFileParsedInImutants(int idItestResult){
		Integer exists = 0;
		String sql = "SELECT DISTINCT 1 FROM imutants WHERE id_iteste_result = ?";
		
		jdbcTemplate = new JdbcTemplate(getConnectionDataSource());
		exists = jdbcTemplate.queryForObject(sql, new Object[] {idItestResult}, Integer.class);
		
		return exists == 1;
	}	
}
