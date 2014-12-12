package mc437.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import mc437.bean.Teste;
import mc437.bean.ITestResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TesteDAO {

	@Autowired
	DataSource datasource;

	public List<ITestResultBean> getFiles() {
		JdbcTemplate template = new JdbcTemplate(datasource);
		return template.query("SELECT * FROM I_Test_Result",
				new RowMapper<ITestResultBean>() {

					@Override
					public ITestResultBean mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						ITestResultBean xml = new ITestResultBean(rs
								.getString("file_name"), rs
								.getLong("file_size"), new Date(rs
								.getTimestamp("date").getTime()));
						xml.setId(rs.getInt("id"));
						return xml;
					}

				});
	}

	public int saveFile(ITestResultBean file) {
		String sql = "SELECT MAX(id) FROM I_Test_Result";

		JdbcTemplate template = new JdbcTemplate(datasource);
		template.update(
				"INSERT INTO I_Test_Result(date,file_size,file_name) VALUES (?, ?, ?)",
				new Object[] { file.getDataEnvio(), file.getTamanho(),
						file.getNome() }, new int[] { Types.TIMESTAMP,
						Types.INTEGER, Types.VARCHAR });

		return template.queryForObject(sql, new Object[] {}, Integer.class);
	}

	public List<Teste> getAllTests() {
		JdbcTemplate template = new JdbcTemplate(datasource);
		return template.query("SELECT * FROM Teste", new RowMapper<Teste>() {

			@Override
			public Teste mapRow(ResultSet rs, int rowNum) throws SQLException {
				Teste teste = new Teste();
				teste.setId(rs.getInt("id"));
				teste.setTexto(rs.getString("texto"));

				return teste;
			}

		});
	}

}
